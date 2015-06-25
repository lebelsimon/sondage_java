import java.sql.*;
import java.util.ArrayList;

/**
 * @author Damien MARTIN
 */

public class QuestionnaireBD{
	private ConnexionMySQL c;
	private Statement s, s2, s3;
	private QuestionBD qBD;

	// constructeur
	public QuestionnaireBD(ConnexionMySQL c) throws SQLException {
		try {
			this.c = c;
			Connection conn = c.getConnexion();
			this.s = conn.createStatement();
			this.s2 = conn.createStatement();
			this.s3 = conn.createStatement();
			this.qBD=new QuestionBD(c);
			System.out.println("questionnaireBD créé");
		} 
		catch (SQLException e) {
			System.out.println("questionnaireBD non créé");
		}
	}
	
	/**
	 * 
	 * @param idU l'id de l'utilisateur
	 * @param role son role
	 * @return une liste de questionnaire dont l'utilisateur a la charge
	 */
	 //ertourne la liste des questionnaire de la BD
	public ArrayList<Questionnaire> getListeQuestionnaire(int idU, String role){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		ArrayList<String> questionAjoutee = new ArrayList<String>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM INTERROGER i, QUESTIONNAIRE q , QUESTION qu WHERE i.idU="+idU+" AND q.Etat='"+role.charAt(0)+"'");
			int idQcourant=-1;
			while(rs.next()){
				// si c'est le même questionnaire
				if(rs.getInt("q.idQ")==idQcourant){
					// on crée une nouvelle question et on lui ajoute la liste des propositions
					Question question = new Question(rs.getString("qu.texteQ"), rs.getString("qu.idT").charAt(0), rs.getInt("qu.maxVal"), rs.getInt("qu.numQ"));
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("qu.idQ"), rs.getInt("qu.numQ")));
					if(!questionAjoutee.contains(question.getTexteQuestion())){
						listeQuestion.add(question);
						questionAjoutee.add(question.getTexteQuestion());
					}
				}
				// sinon c'est un nouveau questionnaire
				else{
					// on crée une nouvelle liste de question
					listeQuestion = new ArrayList<Question>();
					// on crée un nouveau questionnaire
					Questionnaire q = new Questionnaire(rs.getString("q.Titre"), rs.getInt("q.numC"), rs.getInt("q.idU"), rs.getInt("q.idPan"), rs.getString("q.etat").charAt(0));
					q.setIdQ(rs.getInt("q.idQ"));
					idQcourant=rs.getInt("q.idQ");
					// on crée une nouvelle question
					Question question = new Question(rs.getString("qu.texteQ"), rs.getString("qu.idT").charAt(0), rs.getInt("qu.maxVal"), rs.getInt("qu.numQ"));
					// on ajoute les propositions de la question
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("qu.idQ"), rs.getInt("qu.numQ")));
					// on ajoute la question à la liste
					if(!questionAjoutee.contains(question.getTexteQuestion())){
						listeQuestion.add(question);
						questionAjoutee.add(question.getTexteQuestion());
					}
					q.setListeQuestions(listeQuestion);
					listeQuestionnaire.add(q);
					
				}
			}
			// on récpère les questionnaires qui ne sont pas associés à des questions.
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTIONNAIRE WHERE Titre NOT IN(SELECT Titre FROM QUESTIONNAIRE NATURAL JOIN QUESTION) AND idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			while(rs2.next()){
				Questionnaire q = new Questionnaire(rs2.getString("Titre"), rs2.getInt("numC"),  rs2.getInt("idU"),  rs2.getInt("idPan"),  rs2.getString("etat").charAt(0));
				q.setListeQuestions(new ArrayList<Question>());
				listeQuestionnaire.add(q);
			}
		}
		catch(SQLException e) { System.out.println(e); }
		return listeQuestionnaire;
	}

	/**
	 * 
	 * @param q un questionnaire a ajouter
	 * permet d'ajouter un nouveau questionnaire dans la base de donnees
	 */
	public void ajouterQuestionnaire(Questionnaire q){
		try{
			// on ajoute un questionnaire
			s.executeUpdate("INSERT INTO QUESTIONNAIRE VALUES ("+this.getMaxIdQ()+", '"+q.getTitreQuestionnaire()+"', 'C', "+ q.getNumC()+", "+q.getIdU()+", "+q.getIdPan()+")");
			for(Question question : q.getListeQuestions()){
				// on ajoute les quesitons correspondantes
				s2.executeUpdate("INSERT INTO QUESTION VALUES ("+q.getIdQ()+", "+question.getNumQ()+", "+question.getTexteQuestion()+", "+question.getMaxVal()+", "+question.getIdT()+")");
				for(int i=0; i<question.getPropositions().getSize(); i++){
					// on ajoute les propositions de chaqque question
					s3.executeUpdate("INSERT INTO VALPOSSIBLE VALUES ("+q.getIdQ()+", "+question.getNumQ()+", "+(i+1)+", "+question.getPropositions().get(i));
				}
			}
		}
		catch(SQLException e){ System.out.println(e); }
	}
	
	/**
	 * permet de recuperer l'id max dans une liste de questionnaire
	 * @return
	 */
	private int getMaxIdQ(){
		try{
			ResultSet rs = s.executeQuery("SELECT MAX(idQ) FROM QUESTIONNAIRE");
			rs.next();
			return rs.getInt("MAX(idQ)")+1;
		}
		catch(SQLException e){System.out.println(e);}
	return 1;
	}
	
	/**
	 * 
	 * @param idQ l'identifiant d'un questionnaire
	 * permet de supprimer toutes les donnees correpondantes à un questionnaire mis en parametre
	 */
	public void supprimerQuestionnaire(int idQ){
		try{
			s.executeUpdate("DELETE FROM VALPOSSIBLE WHERE idQ="+idQ);
			s.executeUpdate("DELETE FROM QUESTION WHERE idQ="+idQ);
			s.executeUpdate("DELETE FROM QUESTIONNAIRE WHERE idQ="+idQ);
		}
		catch(SQLException e){ System.out.println(e);}
	}
	
	/**
	 * 
	 * @param q un questionnaire
	 * permet de modifier un questionnaire dans la base de donnees
	 */
	public void modifierQuestionnaire(Questionnaire q){
		try{
			s.executeUpdate("UPDATE QUESTIONNAIRE SET Titre='"+q.getTitreQuestionnaire()+"', etat='"+q.getEtat()+"', numC="+q.getNumC()+", idU="+q.getIdU()+", idPan="+q.getIdPan()+" WHERE idQ="+q.getIdQ());
		}
		catch(SQLException e){System.out.println(e);}
	}
	
	/**
	 * 
	 * @param q un questionnaire
	 * @param idC un String qui est la catégorie du sonde qui a repondu
	 */
	public void ajouterReponses(Questionnaire q, String idC){
		try{
			for(Integer cle : q.getListeReponses().keySet()){
				s.executeUpdate("INSERT INTO REPONDRE (idQ,numQ,idC,valeur) VALUES ("+q.getIdQ()+","+cle+",'"+idC+"','"+q.getListeReponses().get(cle)+"')");
			}
		}
		catch(SQLException e){ System.out.println(e); }
	}
	
	/**
	 * @param idQ un entier correspondant à l'id du questionnaire
	 * @param idU un entier correspondant à l'id de l'utilisateur
	 * @param role un string qui est le role de l'utilisateur
	 * Permet de créer un questionnaire à partir des informations dans la base de donnees
	 * @return un questionnaire
	 */
	public Questionnaire creerQuestionnaire(int idQ, int idU, String role){
		return this.getListeQuestionnaire(idU, role).get(idQ-1);
	}
	
	/**
	 * @param numSond un entier qui est le numero du sonde
	 * @param idU un entier qui est l'id de l'utilisateur
	 * @param role un String qui est le role de l'utilisateur
	 * permet de récupérer les quesitonnaires pour un sondé donné et correspondant à un utilisateur
	 * @return une liste de questionnaire
	 */
	public ArrayList<Questionnaire> getListeQuestionnaireSonde(int numSond, int idU, String role){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		try{
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTIONNAIRE q, INTERROGER i WHERE q.idQ=i.idQ AND numSond="+numSond+" AND i.idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			while(rs2.next()){
				listeQuestionnaire.add(this.creerQuestionnaire(rs2.getInt("i.idQ"), idU, role));
			}
		}
		catch(SQLException e){
			//System.out.println(e);
			}
		return listeQuestionnaire;
	}
	
	public ArrayList<Questionnaire> getListeQuestionnaireConcepteur(int idU, String role){
		ArrayList<Questionnaire> listeQuestionnaire = new ArrayList<Questionnaire>();
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		ArrayList<String> questionAjoutee = new ArrayList<String>();
		ArrayList<String> questionnaireAjoute = new ArrayList<String>();
		try{
			ResultSet rs = s.executeQuery("SELECT * FROM QUESTIONNAIRE NATURAL JOIN QUESTION WHERE idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			int idQcourant=-1;
			while(rs.next()){
				// si c'est le meme questionnaire
				if(rs.getInt("idQ")==idQcourant){
					// on cree une nouvelle question et on lui ajoute la liste des propositions
					Question question = new Question(rs.getString("texteQ"), rs.getString("idT").charAt(0), rs.getInt("maxVal"), rs.getInt("numQ"));
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("idQ"), rs.getInt("numQ")));
					if(!questionAjoutee.contains(question.getTexteQuestion())){
						listeQuestion.add(question);
						questionAjoutee.add(question.getTexteQuestion());
					}
				}
				// sinon c'est un nouveau questionnaire
				else{
					// on crée une nouvelle liste de question
					listeQuestion = new ArrayList<Question>();
					// on crée un nouveau questionnaire
					Questionnaire q = new Questionnaire(rs.getString("Titre"), rs.getInt("numC"), rs.getInt("idU"), rs.getInt("idPan"), rs.getString("etat").charAt(0));
					questionnaireAjoute.add(rs.getString("Titre"));
					q.setIdQ(rs.getInt("idQ"));
					idQcourant=rs.getInt("idQ");
					// on crée une nouvelle question
					Question question = new Question(rs.getString("texteQ"), rs.getString("idT").charAt(0), rs.getInt("maxVal"), rs.getInt("numQ"));
					// on ajoute les propositions de la question
					question.setPropositions(qBD.getListePropositionPourUneQuestion(rs.getInt("idQ"), rs.getInt("numQ")));
					// on ajoute la question à la liste
					if(!questionAjoutee.contains(question.getTexteQuestion())){
						listeQuestion.add(question);
						questionAjoutee.add(question.getTexteQuestion());
					}
					q.setListeQuestions(listeQuestion);
					listeQuestionnaire.add(q);
				}
			}
			ResultSet rs2 = s2.executeQuery("SELECT * FROM QUESTIONNAIRE WHERE idU="+idU+" AND Etat='"+role.charAt(0)+"'");
			while(rs2.next()){
				if(!questionnaireAjoute.contains(rs2.getString("Titre"))){
					questionnaireAjoute.add(rs2.getString("Titre"));
					Questionnaire q = new Questionnaire(rs2.getString("Titre"), rs2.getInt("numC"), rs2.getInt("idU"), rs2.getInt("idPan"), rs2.getString("etat").charAt(0));
					q.setIdQ(rs2.getInt("idQ"));
					listeQuestionnaire.add(q);
				}
			}
		}
		catch(SQLException e){System.out.println(e);}
		return listeQuestionnaire;
	}
	
	public ArrayList<Integer> getListeIdQ(){
		ArrayList<Integer> listeIdQ = new ArrayList<Integer>();
		try{
			ResultSet rs = s.executeQuery("SELECT idQ FROM QUESTIONNAIRE");
			while(rs.next()){
				listeIdQ.add(rs.getInt("idQ"));
			}
		}
		catch(SQLException e){System.out.println(e);}
		return listeIdQ;
	}
}

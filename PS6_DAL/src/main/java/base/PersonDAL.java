package base;


public class PersonDAL {

	public static PersonDomainModel addPerson(personDomainModel per) {
		
		public static PersonDomainModel addPerson(PersonDomainModel per) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
//			int personID = 0;
			try {
				tx = session.beginTransaction();
				session.save(per);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return per;

			public static ArrayList<PersonDomainModel> getAllPersons() {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;
				PersonDomainModel perGet = null;		
				ArrayList<PersonDomainModel> pers = new ArrayList<PersonDomainModel>();
				
				try {
					tx = session.beginTransaction();
					List persons = session.createQuery("FROM PersonDomainModel").list();
					for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
						PersonDomainModel per = (PersonDomainModel) iterator.next();
						pers.add(per);
					}
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
				return pers;
			}
			
			public static PersonDomainModel getPerson(UUID perID) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;
				PersonDomainModel perGet = null;		
				
				try {
					tx = session.beginTransaction();	
											
					Query query = session.createQuery("from PersonDomainModel where personId = :id ");
					query.setParameter("id", perID.toString());
					
					List<?> list = query.list();
					perGet = (PersonDomainModel)list.get(0);
					
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
				return perGet;
				
				public static void deletePerson(UUID perID) {
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					PersonDomainModel perGet = null;
					try {
						tx = session.beginTransaction();

						PersonDomainModel per = (PersonDomainModel) session.get(PersonDomainModel.class, perID);
						if (per == null) {
							return;
						}
						session.delete(per);
						tx.commit();
					} catch (HibernateException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					} finally {
						session.close();
					}
				}
				
				public static PersonDomainModel updatePerson(PersonDomainModel per) {
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					PersonDomainModel perGet = null;

					try {
						tx = session.beginTransaction();

						session.update(per);

						tx.commit();
					} catch (HibernateException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					} finally {
						session.close();
					}

					return per;
				}
			}
				
				

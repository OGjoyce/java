public class DbTest{
	public static void main(String[] args) {
	 try{
		DB myDb = new DB("testDb.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
		
		System.out.println("executing insert");//AQUI PODRIAMOS GUARDAR LA TABLA PERO HAY QUE APREDNDER A USARLA
		System.out.println(myDb.executeNonQuery("insert into t1 (name,last) values ('juan','perez')"));//insert statement, notice i use executeNonQuery method
		System.out.println(myDb.executeQuery("select * from t1","rs1")); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id","rs1")+" name= "+myDb.getString("name","rs1")+" last= "+myDb.getString("last","rs1")+"\n");
		System.out.println("executing update");
                System.out.println(myDb.executeNonQuery("update t1 set last='lopez' where name='juan';"));
                System.out.println(myDb.executeQuery("select * from t1","rs2")); //execute selectQuery using executeQuery method, I will save this query's results in 'rs2'
                while(myDb.next("rs2"))//next method makes tuple fetch, if there are no more tuples method returns false
                        System.out.print("id= "+myDb.getString("id","rs2")+" name= "+myDb.getString("name","rs2")+" last= "+myDb.getString("last","rs2")+"\n");
                System.out.println("executing delete");
		System.out.println(myDb.executeNonQuery("delete from t1 where name='juan'"));
		myDb.executeQuery("select * from t1","rs3");//save results from query on 'rs3'
                    while(myDb.next("rs3"))
                System.out.print("id= "+myDb.getString("id","rs3")+" name= "+myDb.getString("name","rs3")+" last= "+myDb.getString("last","rs3")+"\n");
			
		myDb.close();//close connection
	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
	}	
}

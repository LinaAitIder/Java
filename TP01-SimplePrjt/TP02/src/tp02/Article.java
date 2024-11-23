package tp02;

public class Article {
    int code;
   static int num=0;
    String libelle;
    float prix;
    
    Article(String L,float P)
    {
       num=num+1; 
       code=num;
       libelle=L;
       prix=P;
    }
    void afficher()
    {
          System.out.println("Code:"+code);
          System.out.println("Libelle:"+libelle);
          System.out.println("Prix:"+prix);
          
    }
    void modifier(float px)
    {
        prix=px;
    }
}

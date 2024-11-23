
package tp02;
import java.util.*;
import java.util.ArrayList;
public class TP02 {
static List<Article> LA= new ArrayList<>();
static void ajouter(Article A)
{
    LA.add(A);
    
}
static void affiche()
{
    int i;
    for(i=0;i<LA.size();i++)
    {
      LA.get(i).afficher();
    }          
}
static void modiferP(int c,float p)
{
    Article AR;
    for(int i=0;i<LA.size();i++)
        if(LA.get(i).code==c)
        {
            AR=LA.get(i);
            AR.prix=p;
        }
}
static void Supprimer(int c)
{
    for(int i=0;i<LA.size();i++)
        if(LA.get(i).code==c)
            LA.remove(i);
}
    public static void main(String[] args) {
       Article AR1=new Article("PC",3000);
       Article AR2=new Article("Scanner",550);
       Article AR3=new Article("Imprimante",600);
       AR1.modifier(4500);
       ajouter(AR1);
       ajouter(AR2);
       ajouter(AR3);
       affiche();
       System.out.println("=============================");
       Supprimer(2);
       affiche();
       
       
          
    }
    
}

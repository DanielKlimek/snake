
package hadik;


public class svet { //vytvorime triedu svet
    



private char[][] pole;
private int sirka ;
private int vyska;         //definovanie premennych
private Hadik hadik;




public svet(int sirka, int vyska){
    
    this.sirka  = sirka+2 ;  //+2 davame pre zvacsenie hranic 
    this.vyska = vyska+2 ;

}

public void init(){
    this.pole = new char[vyska][sirka]; //do pola dame premenne vysku a sirku

    
    for(int x = 0; x < sirka; x++){
        for(int y = 0; y < vyska; y++){  //vytvorime pozadie
            pole[y][x] = '.';
        }
    }

    
    for(int x = 0; x < sirka; x++){
        pole[0][x]          = '#';   //pridame riadky
        pole[vyska - 1][x] = '#';
         }

    for(int y = 0; y < vyska; y++){
        pole[y][0]         = '#';     //pridame stlpce
        pole[y][sirka - 1] = '#';
    }

    
    hadik = new Hadik(); //vytvorime novy objekt Hadik
    hadik.init(this.sirka/2, this.vyska/2); //vysku a sirku som predelil 2 aby sa to zmestilo do pola o velkosti 7 
    pole[hadik.hlava.y][hadik.hlava.x] = 'o'; //do pola som dal suradnice hadika a vykreslil som jeho hlavu


    
    generatorjedla(); //generujem jedlo
    
  
    
        

}

public void pohyb(){
    pole[hadik.hlava.y][hadik.hlava.x] = '.';

    //movement 
    switch(hadik.smer){  //nastavili sme si pohyb pre hada
        case 'w':
            hadik.hlava.y--;
            break;
        case 's':
            hadik.hlava.y++;
            break;
        case 'a':
            hadik.hlava.x--;
            break;
        case 'd':
            hadik.hlava.x++;
            break;

    }
    
 


    //nastavenie pravidiel
    switch(pole[hadik.hlava.y][hadik.hlava.x]){
        case '#':
        case 'o':
            //koniec hry premiestnenie hadika na startovaciu poziciu
            init();
            break;
        case '*':
            //jedenie
            generatorjedla();
            break;

    }

    pole[hadik.hlava.y][hadik.hlava.x] = 'o';

}

public void generatorjedla(){
    bod jedlo = new bod();
    jedlo.x = (int)(Math.random() * (sirka-3)) + 1 ;
    jedlo.y = (int)(Math.random() * (vyska-3)) + 1 ;

    if(jedlo.x == hadik.hlava.x && jedlo.y == hadik.hlava.y){
        
        generatorjedla();
       
             
    }
    else{
        pole[jedlo.y][jedlo.x] = '*';
    }

}

public void kreslenie(){
    for(int y = 0; y < vyska; y++){
        for(int x = 0; x < sirka; x++){
            System.out.print(pole[y][x]);
        }
        System.out.println();
    }

}

public Hadik getHadik(){
    return hadik;
}}


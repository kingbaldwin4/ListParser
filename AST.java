abstract class Exp{

public abstract Object accept(Visitor v);

}

class RNum extends Exp{

int pay;
int payda;


public RNum(String sayi){

if(sayi.length()>1){

pay = Integer.parseInt(String.valueOf(sayi.charAt(0)));
payda=Integer.parseInt(String.valueOf(sayi.charAt(2)));}

else if(sayi.length()==1){
pay =Integer.parseInt(String.valueOf(sayi.charAt(0)));
payda=1;}

else{
pay=1;
payda=1;
}

}

public String toString(){

if(payda==1){
return "RNum(" + (Integer.toString(pay)) + ")";}

else{
return "RNum(" + Integer.toString(pay) + "/" + Integer.toString(payda) + ")";
}
}

public Object accept(Visitor v){
return v.visit(this);
}
}

class X extends Exp{

String x;
RNum rnum = new RNum("1/1");

public X(String x){
this.x = x;
}

public String toString(){
return "X("+x+")";
}

public Object accept(Visitor v){
return v.visit(this);
}
}

class Times extends Exp{

Exp e1,e2;

public Times(Exp a, Exp b){
e1 = a;
e2 = b;
}

public String toString(){
return "Times("+e1+","+e2+")";
}

public Object accept(Visitor v){
return v.visit(this);	
}
}


class Divide extends Exp{

Exp e1,e2;

public Divide(Exp a, Exp b){
e1 = a;
e2 = b;
}

public String toString(){
return "Divide("+e1+","+e2+")";
}

public Object accept(Visitor v) {
return v.visit(this);
}
}

class Power extends Exp{

Exp e1,e2;	

public Power(Exp a, Exp b){
e1 = a;
e2 = b;
}

public String toString(){
return "Power("+e1+","+e2+")";
}
	
public Object accept(Visitor v) {
return v.visit(this);
}
}
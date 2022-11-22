class EvalVisitor implements  Visitor{

public Object visit(Exp e){
return  e.accept(this);
}

public Object visit(Times e){
	
Object x = e.e1.accept(this);
int x_pay1,x_payda1;
		            	
if(x instanceof X){
x_pay1 = 1;
x_payda1 = 1;
}

else{
x_pay1 = ((RNum)x).pay;
x_payda1 = ((RNum)x).payda;
}
					
int tempPayda=x_payda1;
				     	
Object y = e.e2.accept(this);
int y_pay1,y_payda1;
				     	
if(y instanceof X){
y_pay1 = 1;
y_payda1 = 1;
}
		            		
else{
y_pay1 = ((RNum)y).pay;
y_payda1 = ((RNum)y).payda;
}
				
x_pay1=x_pay1 * y_payda1;
x_payda1=x_payda1 * y_payda1;		
					
y_pay1=y_pay1*tempPayda;
y_payda1=y_payda1*tempPayda;
					
int yeniPay=x_pay1+y_pay1;
int yeniPayda=x_payda1;
						
if(x instanceof X || y instanceof X){
RNum  rnum =new RNum("");
rnum.pay=yeniPay;
rnum.payda=yeniPayda;
return rnum;
}

else{
((RNum)y).pay=yeniPay;
((RNum)y).payda=yeniPayda;
return y;
}
}	


public Object visit(Divide e){
Object x = e.e1.accept(this);
int x_pay1,x_payda1;
		            	
if(x instanceof X){
x_pay1 = 1;
x_payda1 = 1;
}

else{
x_pay1 = ((RNum)x).pay;
x_payda1 = ((RNum)x).payda;
}
					
int tempPayda=x_payda1;
Object y = e.e2.accept(this);
int y_pay1,y_payda1;
				     	
if(y instanceof X){
y_pay1 = 1;
y_payda1 = 1;
}

else{
y_pay1 = ((RNum)y).pay;
y_payda1 = ((RNum)y).payda;
}
				
x_pay1=x_pay1 * y_payda1;
x_payda1=x_payda1 * y_payda1;	

y_pay1=y_pay1*tempPayda;
y_payda1=y_payda1*tempPayda;
					
int yeniPay=x_pay1-y_pay1;
int yeniPayda=y_payda1;
						
if(y instanceof X ||x instanceof X){							
RNum  rnum =new RNum("");
rnum.pay=yeniPay;
rnum.payda=yeniPayda;
return rnum;
}

else{
((RNum)y).pay=yeniPay;
((RNum)y).payda=yeniPayda;
return y;
}
}

public Object visit(Power e){

Object x = e.e1.accept(this);
Object y = e.e2.accept(this);
                    
if(x instanceof X){					
return y;					  
}

else{					    			
int x_pay1 = ((RNum)x).pay;
int x_payda1 = ((RNum)x).payda;
				     				     	
int y_pay1 = ((RNum)y).pay;
int y_payda1 = ((RNum)y).payda;

				
int yeniPay=x_pay1*y_pay1;
int yeniPayda=x_payda1*y_payda1;

((RNum)y).pay=yeniPay;
((RNum)y).payda=yeniPayda;
				  							
return y;
}
}

public Object visit(X e){

return	e;
}
public Object visit(RNum e){
	
return e;
}		
}



	
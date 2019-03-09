package Week3;

import java.util.Iterator;
import java.util.TreeSet;

public class Polynomial {

    private Term terms;
    private Term lastTerm;

    public Polynomial(int[] coefficient, int[] exponent) {


            //throw new MathmeticsException("The length of coefficient should equal to the length of exponent ");

        TreeSet treeSet = new TreeSet();
        try {
            for (int i = 0; i < coefficient.length; i++) {
                treeSet.add(new Term(coefficient[i], exponent[i]));
                Iterator iterator = treeSet.iterator();
                terms = (Term)iterator.next();
                Term temp = terms;
                while(iterator.hasNext()){
                    temp.nextTerm = (Term)iterator.next();
                    temp = temp.nextTerm;
                }
                lastTerm = temp;
            }

        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


    }

    public Polynomial() {
        terms = new Term(0, 0);
        lastTerm = terms;
    }

    public static Polynomial add(Polynomial poly1, Polynomial poly2){
        Polynomial polynomial = new Polynomial();
        Term term1 = poly1.terms;
        Term term2 = poly2.terms;
        int exp1;
        int exp2;
        while(term1 != null && term2 != null) {
            exp1 = term1.getExponent();
            exp2 = term2.getExponent();
            if(exp1 < exp2){
                polynomial.addTerm(term1);
            } else if (exp1 > exp2){
                polynomial.addTerm(term2);
            } else {
                polynomial.addTerm(term2.getCoefficient(), exp1 + exp2);
            }


            term1 = term1.nextTerm;
            term2 = term2.nextTerm;
        }

        while (term1 != null){
            polynomial.addTerm(new Term(term1));
            term1 = term1.nextTerm;
        }

        while (term2 != null){
            polynomial.addTerm(new Term(term2));
            term2 = term2.nextTerm;
        }

        polynomial.terms = polynomial.terms.nextTerm;

        return polynomial;
    }

    private void addTerm(int nextCoefficient, int nextExponent){
        lastTerm.nextTerm = new Term(nextCoefficient, nextExponent);
        lastTerm = lastTerm.nextTerm;
    }

    private void addTerm(Term nextTerm){
        lastTerm.nextTerm = new Term(nextTerm);
        lastTerm = lastTerm.nextTerm;

    }


    public static void main(String[] args) {
        int[] exp1 = {1,2,3,4,5}, exp2 = {5,4,3,2,1}, coe = {2,3,46,6,44}, coe2 = {2,4,53,2,4};
        Polynomial a = new Polynomial(coe, exp1), b = new Polynomial(exp2, coe2);
        Polynomial sum = add(a, b);
    }


}


class Term implements Comparable{
    private int coefficient;
    private int exponent;
    Term nextTerm;

    Term(int coefficient, int exponent, Term nextTerm) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.nextTerm = nextTerm;
    }

    Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

//    private Term dublicateTermTerm(){
//        Term dublicateTerm = new Term(this.coefficient, this.exponent);
//        Term temp = dublicateTerm;
//        while(temp.hasNext()) {
//            temp = temp.nextTerm;
//        }
//    }

    Term(Term term){
        this.coefficient = term.coefficient;
        this.exponent = term.exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    boolean hasNext(){
        return nextTerm != null;
    }

    @Override
    public int compareTo(Object obj){
        Term o = (Term)obj;
        if(o.exponent <= this.exponent){
            return -1;
        } else
            return 1;
    }



}



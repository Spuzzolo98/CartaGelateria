
package ClassiVarie;


public class Carta {
    private String data="", nomeutente, cognomeutente;
    private int giornor, meser, annor, codiceid=1000000, puntitot, nreset;

    public String getData() {
        return data;
    }

    public void setData(int giornorr, int meserr, int annorr) {
        this.data = giornorr+"-"+meserr+"-"+annorr;
    }

    public String getNomeutente() {
        return nomeutente;
    }

    public void setNomeutente(String nomeutente) {
        this.nomeutente = nomeutente;
    }

    public String getCognomeutente() {
        return cognomeutente;
    }

    public void setCognomeutente(String cognomeutente) {
        this.cognomeutente = cognomeutente;
    }

    public int getCodiceid() {
        return codiceid;
    }

    public void setCodiceid(int codiceid) {
        this.codiceid = codiceid;
    }

    public int getPuntitot() {
        return puntitot;
    }

    public void setPuntitot(int puntitot) {
        this.puntitot = this.puntitot + puntitot;
    }
    
    public boolean elaboropunti(int puntitot){
        setPuntitot(puntitot);
        if(this.puntitot>=20){
            switch(puntitot){
                case 1:
                    this.puntitot = this.puntitot - 20;
                break;
                case 2:
                    this.puntitot = this.puntitot - 21;
                break;
                case 3:
                    this.puntitot = this.puntitot - 21;
                break;               
            }
            return true;
        }
        else
            return false;
    }
    

    public int getNreset() {
        return nreset;
    }

    public void setNreset(int nreset) {
        this.nreset = nreset;
    }
    
    public Carta(String nomerr){
        this.nomeutente = nomerr;
    }
    
}

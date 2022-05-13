
/**
 * Write a description of Part1 here.
 * Program to find the first stop codon i.e. either "TAA" or "TAG" or "TGA" and print the gene and later find all genes present in the DN
 */
public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        startIndex = dna.indexOf("ATG",startIndex); 
        if(startIndex == -1) {
            return dna.length();
        }
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        /*if(stopIndex == -1) {
            return -1;
        }*/
        int diff = stopIndex - startIndex;
        if(diff % 3 == 0) {
            return stopIndex;
        }
        return dna.length();
    }
    
    public String findGene(String dna,int where) {
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex==-1) {
            return "";
        }
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = Math.min(tagIndex,taaIndex);
        minIndex = Math.min(tgaIndex,minIndex);
        if((minIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex,minIndex+3);
        }
        return "";
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        while(true) {
        String currGene = findGene(dna,startIndex);
        if(currGene.isEmpty()) {
            break;
        }
        System.out.println(currGene);
        startIndex = dna.indexOf(currGene,startIndex)+currGene.length();
        }
    }
    //public void testStopCodon() {
        //System.out.println(findStopCodon("ATGCTGGCTTGACTA",0,"TGA"));
    //}
    
    /*public void testFindGene() {
        String dna = "";
        String gene = "";
        dna = "ATGCTGTAACGT";
        gene = findGene(dna);
        System.out.println(dna);
        System.out.println(gene);
        //System.out.println(findGene("ATGCTGTCTAAACATA"));
        dna = "CTGTAACGT";
        gene = findGene(dna);
        System.out.println(dna);
        System.out.println(gene);
    }*/
    
    public void testAllGenes() {
        printAllGenes("ATGTACTAACGTATGCGTTAGTGCCTGATGCTATGCTG");
    }
    public static void main(String args[]) {
                Part1 part11 = new Part1();
                part11.testAllGenes();
        }
}

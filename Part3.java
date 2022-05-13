
/**
 * A program to count how many genes are in a strand of DNA. A gene must start with a codon "ATG" and end with either "TAA" or "TAG" or "TGA" codon.
 * A gene's length of characters must be a multiple of 3. 
 * The method named countGenes that has a String parameter named dna representing a string of DNA. This method returns the number of genes found in dna.
 * For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG.
 * The method testCountGenes calls countGenes with many example strings and prints the result for each.
 * @author (Sushma) 
 * @version (5/12/2022)
 */
public class Part3 {
        public int findStopCodon(String dna,int startIndex,String stopCodon) {
        startIndex = dna.indexOf("ATG",startIndex); 
        if(startIndex == -1) {
            return -1;
        }
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        if(stopIndex == -1) {
            return -1;
        }
        int diff = stopIndex - startIndex;
        if(diff % 3 == 0) {
            return stopIndex;
        }
        return -1;
    }
    
    public String findGene(String dna,int where) {
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex==-1) {
            return "";
        }
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = tagIndex;
        if(tagIndex == -1 || (taaIndex != -1 && taaIndex < tagIndex)) {
            minIndex = taaIndex;
        }
        if(tgaIndex == -1 || (minIndex != -1 && minIndex < tgaIndex)){
            minIndex = minIndex;
        }
        else {
            minIndex = tgaIndex;
        }
        if(minIndex == -1)
        {
            return "";
        }
        if((minIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex,minIndex+3);
        }
        return "";
    }
    
    public int countGenes(String dna) {
        int count = 0;
        int startIndex = 0;
        while(true) {
        String currGene = findGene(dna,startIndex);
        if(currGene.isEmpty()) {
            break;
        }
        count++;
        startIndex = dna.indexOf(currGene,startIndex)+currGene.length();
        }
        
        return count;
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
    
    public void testCountGenes() {
        String dna1 = "ATTCGTGCTATGACGTGCTAGCTGGCT";
        int genesCount1 = countGenes(dna1);
        System.out.println("The gene count in DNA " + dna1 + " is " + genesCount1);
        String dna2 = "ATGCGTTAGGCTATGACGTGCTGACTGGCT";
        int genesCount2 = countGenes(dna2);
        System.out.println("The gene count in DNA " + dna2 + " is " + genesCount2);
        String dna3 = "ATTCGATGCTCTGACGTGCTACTGGCT";
        int genesCount3 = countGenes(dna3);
        System.out.println("The gene count in DNA " + dna3 + " is " + genesCount3);
        String dna4 = "ATTCGTGCATGTATACGTGCTAGCTGATGGCTTAGACT";
        int genesCount4 = countGenes(dna4);
        System.out.println("The gene count in DNA " + dna4 + " is " + genesCount4);
        }
        public static void main(String args[]) {
                Part3 part31 = new Part3();
                part31.testCountGenes();
        }
}

/*
ADS_Module-2_Problem solving using Java Strings and Collections Library-2
In this code, I didnot check with the date and time format only, instead of the
date and time I checked using string name itself.
*/
import java.util.*;


class Candidate implements Comparator<Candidate> , Comparable<Candidate> {
	double rollNo;
	double mathMarks;
	double scienceMarks;
	double englishMarks;
	double socialMarks;
	double languageOneMarks;
	String name;

	Candidate(double rollNo , double mathMarks , double scienceMarks , double englishMarks , double socialMarks , double languageOneMarks , String name) {
		this.rollNo = rollNo;
		this.mathMarks = mathMarks;
		this.scienceMarks = scienceMarks;
		this.englishMarks = englishMarks;
		this.socialMarks = socialMarks;
		this.languageOneMarks = languageOneMarks;
		this.name = name;
	}

	Candidate() {}

	public double getMathMark() {
		return this.mathMarks;
	}

	public double getScienceMark() {
		return this.scienceMarks;
	}

	public double getEnglishMark() {
		return this.englishMarks;
	}

	public double getSocialMark() {
		return this.socialMarks;
	}

	public double getLanguageOneMark() {
		return this.languageOneMarks;
	}

	public String getName() {
		return this.name;
	}

	public double getGPA() {
		double total = mathMarks + scienceMarks + englishMarks + socialMarks + languageOneMarks;
		double gpa = total/5;
		return gpa;
	}


	public int compareTo(Candidate c) {
		return (this.name).compareTo(c.name);
	}

	public int compare(Candidate c, Candidate c1) {
		if( (c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks) && (c.scienceMarks == c1.scienceMarks) && 
			(c.englishMarks == c1.englishMarks) && (c.socialMarks == c1.socialMarks) && (c.languageOneMarks == c1.languageOneMarks) &&
			(c.name.equalsIgnoreCase(c1.name))) {
			return (int)(c.rollNo - c1.rollNo);
		
		} else if ((c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks) && (c.scienceMarks == c1.scienceMarks) && 
				  (c.englishMarks == c1.englishMarks) && (c.socialMarks == c1.socialMarks) && (c.languageOneMarks == c1.languageOneMarks) ) {
				  	return c.name.compareTo(c1.name);
		
		} else if((c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks) && (c.scienceMarks == c1.scienceMarks) && 
				  (c.englishMarks == c1.englishMarks) && (c.socialMarks == c1.socialMarks)) {
					return (int)(c.languageOneMarks - c1.languageOneMarks);
		
		} else if((c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks) && (c.scienceMarks == c1.scienceMarks) && 
				  (c.englishMarks == c1.englishMarks)) {
					return (int)(c.socialMarks - c1.socialMarks);
		
		} else if((c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks) && (c.scienceMarks == c1.scienceMarks)) {
				return (int)(c.englishMarks - c1.englishMarks);
		
		} else if((c.getGPA() == c1.getGPA()) && (c.mathMarks == c1.mathMarks)) {
			return (int)(c.scienceMarks - c1.scienceMarks);
		
		} else if((c.getGPA() == c1.getGPA())) {
			return (int)(c.mathMarks - c1.mathMarks);
		
		} else {
			return (int)(c.getGPA() - c1.getGPA());
		}


	}

}

class CandidateList {
	List<Candidate> candidates;

	CandidateList() {
		candidates = new ArrayList<Candidate>();
	}

	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}

	public void getCandidatesList() {	
		Collections.sort(candidates , new Candidate());
		for(Candidate c : candidates) {
			System.out.print(c.getName() + "(" + c.getGPA() + "),");
		}

	}
}

class ProblemOne {
	public static void main(String[] args) {

		CandidateList cl = new CandidateList();
		Scanner scan = new Scanner(System.in);

		cl.addCandidate(new Candidate(102 ,67 , 57 , 77 , 72 , 85 , "Murthy"));
		cl.addCandidate(new Candidate(103 , 77 , 67 , 87 , 93 , 86 , "Murthy"));
		cl.addCandidate(new Candidate(101 , 47 , 87 , 97 , 74 , 87 , "Murthy"));
		cl.getCandidatesList();
	}
}
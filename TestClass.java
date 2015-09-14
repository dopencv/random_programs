import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TestClass {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream,true);
		StudentInfoSystem std_system = new StudentInfoSystem();
		std_system.input(in,out);
		std_system.report(out);
		out.close();
	}
}
class StudentInfoSystem {
	private int N;  // no of students
	private int sub_nos = 5;  
	private Student[] students;
	public void input(InputReader in,PrintWriter out) {
		N = in.nextInt();
		students = new Student[N]; 
		for(int i=0;i<N;i++) {
			students[i] = new Student();
			students[i].setRoll(in.nextInt());
			students[i].setName(in.next());
			students[i].setStandard(in.nextInt());
			int[] marks = new int[sub_nos];
			for(int j=0;j<sub_nos;j++) {
				marks[j] = in.nextInt();
			}
			students[i].setMarks(marks);
		}
	}
	// to print all student report
	public void report(PrintWriter out) {
		for(int i=0;i<N;i++) {
			out.println("Name : "+students[i].getName());
			out.println("Roll No : "+students[i].getRoll());
			out.println("Standard : " + students[i].getStandard());
			for(int mark:students[i].getMarks()) {
				out.print(mark); out.print(" ");
			}
			out.println();
			out.println("--------------------------");
		}
		
		int max_mark;
		String max_mark_std;		
		for(int i=0;i<sub_nos;i++) {
			max_mark = students[0].getMarks()[i];
			max_mark_std = students[0].getName();
			for(int std = 1;std<N;std++) {
				if(max_mark < students[std].getMarks()[i]) {
					max_mark = students[std].getMarks()[i];
					max_mark_std = students[std].getName();
				}
			}
			out.println("Max Mark in "+(i+1)+" subject is "+max_mark+" by "+ max_mark_std);
		}
	}
	// to print individual report
	// not used now
	public void report(Student std,PrintWriter out) {
		out.println("Name : "+std.getName());
		out.println("Roll No : "+std.getRoll());
		out.println("Standard : " + std.getStandard());
		for(int mark:std.getMarks()) {
			out.print(mark); out.print(" ");
		}
		out.println();
		out.println("--------------------------");
	}
}
class Student {
	private int roll;
	private String name;
	private int standard;
	private int[] marks = new int[5];	
	public Student() {
		roll = 0;
		name = "";
		standard = 0;
		for(int i=0;i<5;i++) {
			marks[i] = 0;
		}
	}
	public int getRoll() { return roll; }
	public void setRoll(int roll) { this.roll = roll; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getStandard() { return standard; }
	public void setStandard(int standard) { this.standard = standard; }
	public int[] getMarks() { return marks; }
	public void setMarks(int[] marks) { this.marks = marks; }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
    public BigInteger nextbiginteinteger() {
        return new BigInteger(next());
    }
}

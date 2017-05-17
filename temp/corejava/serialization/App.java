package p2.corej.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class App {

	public static void main(String[] args) {

		Date dd = new Date();

		Doctor d1 = new Doctor(12, "Dr. J","Phy",dd);

		Patient p1 = new Patient(11, "Pat", d1, dd);
		
		try {
			// Serialization
			FileOutputStream fos = new FileOutputStream("./patient.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(p1);
			out.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//Deserializing patient object
		FileInputStream fis=null;
		Patient p2 = null;
		ObjectInputStream in =null;
		try {
		
			fis= new FileInputStream("./patient.txt");
			in = new ObjectInputStream(fis);
			p2 = (Patient) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				in.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		System.out.println("Deserializing Patient object with unserialized Doctor as: \n"+p2);

		System.out.println("Approach 1 to fix above");
		
		SerializedDoctor d3 = new SerializedDoctor(12, "Dr. Ab","Physician", dd);
		
		Patient p3 = new Patient(11, "Pat1", d3, dd);
		
		try {
			// Serialization
			FileOutputStream fos = new FileOutputStream("./patient.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(p3);
			out.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//Deserializing patient object
		try {
		
			fis= new FileInputStream("./patient.txt");
			in = new ObjectInputStream(fis);
			p2 = (Patient) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				in.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		System.out.println("Deserializing Patient object with serialized Doctor as: \n"+p2);
		
		System.out.println("Approach 2 to fix");

		Patient pe = new PatientExternalizable(12,"PAtrix",d1,dd);
		
		try {
			// Serialization
			FileOutputStream fos = new FileOutputStream("./patient.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pe);
			out.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//Deserializing patient object
		try {
		
			fis= new FileInputStream("./patient.txt");
			in = new ObjectInputStream(fis);
			p2 = (Patient) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				in.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		System.out.println("Deserializing Patient object with unserialized Doctor as: \n"+p2);
	}
}



package p2.corej.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppStore {
	public static void main(String[] args) {

		
		/*Store s = new Store("My","Vodafone", "iPune");
		try { // Serialization
			FileOutputStream fos = new FileOutputStream("./store11.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(s);
			out.close();
			fos.close();

		} catch (FileNotFoundException e) { // TODO Auto-generated catch
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		

		// Deserializing patient object
		FileInputStream fis = null;
		Store ss = null;
		ObjectInputStream in = null;
		try {

			fis = new FileInputStream("./store11.txt");
			in = new ObjectInputStream(fis);
			ss = (Store) in.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				in.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ss);
	}
}
package p2.corej.serial;

import java.util.Date;

public class Doctor {

	
	int id;
	String name;
	String specialist;
	Date createdOn;

	
	public Doctor(int id, String name, String specialist, Date createdOn) {
		super();
		this.id = id;
		this.name = name;
		this.specialist = specialist;
		this.createdOn = createdOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialist="
				+ specialist + "]";
	}
	
	
}
package p2.corej.serial;

import java.io.Serializable;

public class Edpt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String eName;

	public Edpt(String eName) {
		super();
		this.eName = eName;
	}
	
	
	
}
package p2.corej.serial;

import java.io.Serializable;

public class Enterprise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String eName;

	public Enterprise(String eName) {
		super();
		this.eName = eName;
	}
	
	
}
package p2.corej.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8002833880213064056L;
	
	int patientId;
	String name;
	Doctor consultant;
	Date startedOn;
	
	
	
	public Patient(int patientId, String name, Doctor consultant, Date startedOn) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.consultant = consultant;
		this.startedOn = startedOn;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Doctor getConsultant() {
		return consultant;
	}
	public void setConsultant(Doctor consultant) {
		this.consultant = consultant;
	}
	public Date getStartedOn() {
		return startedOn;
	}
	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}
	
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name
				+ ", consultant=" + consultant + ", treatedOn=" + startedOn
				+ "]";
	}
	
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(this.getPatientId());
		out.writeObject(this.getName());
		out.writeObject(this.getStartedOn());
		out.writeObject(this.getConsultant().getId());
		out.writeObject(this.getConsultant().getName());
		out.writeObject(this.getConsultant().getSpecialist());
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		this.patientId = (int) in.readObject();
		this.name = (String) in.readObject();
		this.startedOn= (Date) in.readObject();
		
		int id = (int) in.readObject();
		String name= (String) in.readObject();
		String specialist = (String) in.readObject();
		Doctor d = new Doctor(id, name, specialist, null);
		this.consultant = d;
	}
	
	public Object writeReplace() throws ObjectStreamException{
		System.out.println("Called... writeReplace() method");
		return this;
	}

	
	public Object readResolve() throws ObjectStreamException{
		System.out.println("Cannot deserialized");
		return this;
	}
	
}
package p2.corej.serial;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class PatientExternalizable extends Patient implements Externalizable{

	public PatientExternalizable(){
		super(1,"a",null,null);
	}
	
	public PatientExternalizable(int patientId, String name, Doctor consultant,
			Date startedOn) {
		super(patientId, name, consultant, startedOn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.getPatientId());
		out.writeObject(this.getName());
		out.writeObject(this.getStartedOn());
		out.writeObject(this.getConsultant().getId());
		out.writeObject(this.getConsultant().getName());
		out.writeObject(this.getConsultant().getSpecialist());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		this.patientId = (int) in.readObject();
		this.name = (String) in.readObject();
		this.startedOn= (Date) in.readObject();
		
		int id = (int) in.readObject();
		String name= (String) in.readObject();
		String specialist = (String) in.readObject();
		Doctor d = new Doctor(id, name, specialist, null);
		this.consultant = d;
	}

}
package p2.corej.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializedDoctor extends Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SerializedDoctor(int id, String name, String specialist,
			Date createdOn) {
		super(id, name, specialist, createdOn);
	}

	

	public void writeObject(ObjectOutputStream os) throws IOException{
		os.writeInt(this.getId());
		os.writeObject(this.getName());
		os.writeObject(this.getSpecialist());
	}

	public void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
		this.id = is.readInt();
		this.name = (String) is.readObject();
		this.specialist =(String) is.readObject();
		
	}
	
}
package p2.corej.serial;

import java.io.ObjectStreamException;

public class Store extends Edpt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */


	String storeName;
	String location;
	
	public Store(){
		super("10");
	}
	public Store(String name, String storeName, String location) {
		super(name);
		this.storeName = storeName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Store [storeName=" + storeName + ", location=" + location +", bossName=" + eName+ "]";
	}
	
	
	/* private void readObjectNoData()
		     throws ObjectStreamException{
		 System.out.println("Reading object...");
	 }*/
	
}

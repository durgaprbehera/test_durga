package programs.aligntech;

public class PrintDoctorNurse {

    //In a hospital app, there are two users - Doctor & Nurse. Provide solution to perform Login as below.
//Expectation:
//hospital.doctor.login() - Prints Logged In as Doctor
//hospital.nurse.login() - Prints Logged In as Nurse
    public static void main(String[] args){
        Hospital hospital = new Hospital();
        hospital.doctor.login();
        hospital.nurse.login();
    }
}

class Hospital {
    public static class Doctor {
        void login(){
            System.out.println("Prints logged in as Doctor");
        }
    }

    public static class Nurse{
        void login(){
            System.out.println("Prints logged in as Nurse");
        }
    }

    public Doctor doctor = new Doctor();
    public Nurse nurse = new Nurse();
}

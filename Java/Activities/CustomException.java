package activities;

public class CustomException extends Exception {

         String message;

        CustomException(String message){
           this.message= message;
        }

    @Override
    public String getMessage() {
        return message;
    }
    }


package ma.iao.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceResponse {

	   private boolean success;
	    private String message;
	    private Object data;

	    public ServiceResponse() {}

	    public ServiceResponse(boolean success, String message) {
	        this.success = success;
	        this.message = message;
	    }

	    public ServiceResponse(boolean success, String message, Object data) {
	        this.success = success;
	        this.message = message;
	        this.data = data;
	    }

	    public boolean isSuccess() {
	        return success;
	    }

	    public void setSuccess(boolean success) {
	        this.success = success;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }
	    
}

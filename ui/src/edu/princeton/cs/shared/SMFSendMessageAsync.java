package edu.princeton.cs.shared;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import edu.princeton.cs.client.SMFDMailComposer;
import edu.princeton.cs.shared.SMFEJsonRpc.SMFEJsonRpcException;

public class SMFSendMessageAsync implements RequestCallback{

	private SMFDMailComposer composer;
	
	public SMFSendMessageAsync (SMFDMailComposer composer) {
		this.composer = composer;
	}
	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() != Response.SC_OK) {
			Window.alert("Error processing request! ["+response.getStatusCode()+"].");
			return;
		}
		String jsonStr = response.getText();
		//Window.alert(jsonStr);
		JSONValue val = null;
		try {
			val = SMFEJsonRpc.decodeRespose(jsonStr);
		} catch (SMFEJsonRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = null;
		JSONBoolean status = null;
		if (val != null) {
			if ((obj = val.isObject()) != null) {
				val = obj.get("status");
				if ((val != null) && (status = val.isBoolean()) == null)
					Window.alert("Sending Failed...\nSorry, we don't have a Drafts box yet!");
				composer.unloadSendDialog();
			}
			composer.unloadSendDialog();
		}
		else {
			Window.alert("Invalid JSON String.");
			composer.unloadSendDialog();
		}
	}


	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}

}

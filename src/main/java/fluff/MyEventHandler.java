package fluff;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.equo.comm.api.ICommService;
import com.equo.comm.api.actions.IActionHandler;
import com.equo.comm.api.annotations.EventName;

@Component
public class MyEventHandler implements IActionHandler {

	@Reference
	private ICommService commService;

	@EventName("MyEventHandler")
	public String myFirstEvent(String payload) {
		System.out.println("First event: " + payload);
		commService.send("MyJavaEvent", "This is your first message received from Java");
		return payload;
	}
}

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }
}

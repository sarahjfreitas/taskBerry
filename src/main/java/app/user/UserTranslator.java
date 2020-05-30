package app.user;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserTranslator {
    public static List<User> translate(List<UserData> from) {
        List<User> users = new ArrayList<User>();
        from.forEach(userData -> users.add(translate(userData)));
        return users;
    }

    public static User translate(UserData from){
        if(from == null)
            return null;

        User user = new User();
        user.setUserId(from.userId);
        user.setUsername(from.username);
        user.setEmail(from.email);
        user.setName(from.name);
        user.setPassword(from.password);
        if (from.active == 1) {
            user.activate();
        } else {
            user.deactivate();
        }
        user.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        user.setUpdatedIn(Instant.ofEpochSecond(from.updatedIn));
        user.setDisabledIn(Instant.ofEpochSecond(from.disabledIn));

        return user;
    }

    public static UserData translate(User from) {
        UserData user = new UserData();
        user.userId = from.getUserId();
        user.name = from.getName();
        user.username = from.getUsername();
        user.email = from.getEmail();
        user.password = from.getPassword();
        user.active = from.isActive() ? 1 : 0;
        user.createdIn = from.getCreatedIn() != null ? from.getCreatedIn().getEpochSecond() : null;
        user.updatedIn = from.getUpdatedIn() != null ? from.getUpdatedIn().getEpochSecond() : null;
        user.disabledIn = from.getDisabledIn() != null ? from.getDisabledIn().getEpochSecond() : null;

        return user;
    }
}
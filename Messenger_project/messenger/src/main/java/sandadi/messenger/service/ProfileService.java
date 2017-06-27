package sandadi.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sandadi.messenger.database.Database;
import sandadi.messenger.model.Profile;

public class ProfileService {
	private HashMap<String, Profile> profiles = Database.profiles;

	public ProfileService() {
		profiles.put("Sandadi", new Profile("Dinesh", 1, 22));
	}

	public Profile getProfile(String name) {
		return profiles.get(name);
	}

	public List<Profile> getAllProfiles() {
		System.out.println("Came here:");
		return new ArrayList<Profile>(profiles.values());

	}

	public Profile addProfile(Profile p) {
		p.setId(profiles.size() + 1);
		profiles.put(p.getName(), p);
		return p;
	}

	public Profile updateProfile(Profile p) {
		if (p.getId() <= 0)
			return null;
		profiles.put(p.getName(), p);
		return profiles.get(p.getName());
	}

	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}
}

/**
 * 
 */
package org.riks.restresearch.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.riks.restresearch.messenger.DatabaseClass;
import org.riks.restresearch.messenger.model.Profile;

/**
 * @author Siddharth
 *
 */
public class ProfileService {
	
	public ProfileService(){
		DatabaseClass.getProfile().put("Rikin", new Profile(1L,"rikslovein", "rikin", "patel"));
	}

	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(DatabaseClass.getProfile().values());
	}

	public Profile getProfile(String profileName){
		return DatabaseClass.getProfile().get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(DatabaseClass.getProfile().size()+1);
		DatabaseClass.getProfile().put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(!profile.getProfileName().isEmpty()){
			DatabaseClass.getProfile().replace(profile.getProfileName(), profile);
			return profile;
		}
		return null;
	}
	
	public Profile removeProfile(String profileName){
		return DatabaseClass.getProfile().remove(profileName);
	}
}

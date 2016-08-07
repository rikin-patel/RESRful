/**
 * 
 */
package org.riks.restresearch.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.riks.restresearch.messenger.model.Profile;
import org.riks.restresearch.messenger.service.ProfileService;

/**
 * @author Siddharth
 *
 */
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService service = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return service.getProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName){
		return service.getProfile(profileName);
	}

	@POST
	public Response addProfile(Profile profile, @Context UriInfo uriInfo){
		Profile returnVal = service.addProfile(profile);
		URI uri = uriInfo.getAbsolutePathBuilder().path(returnVal.getProfileName()).build();
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName, Profile profile){
		profile.setProfileName(profileName);
		return service.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName")String profileName){
		return service.removeProfile(profileName);
	}
}

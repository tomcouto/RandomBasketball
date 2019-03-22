package edu.quinnipiac.randombasketball;

/**
 * Handler class deals with retrieving the information from the JSON and returning the string
 * in each specified value.
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Handler {

    //getName gets the players first and last name concats them and returns the string
    public String getName(String nameJsonStr) throws JSONException {
        JSONObject nameJSONObj = new JSONObject(nameJsonStr);
        String fullName = (nameJSONObj.getString("first_name")) + " " + (nameJSONObj.getString("last_name"));
        return fullName;
    }

    //gets the player's position from JSON
    public String getPosition(String positionJsonStr) throws JSONException {
        JSONObject positionJSONObj = new JSONObject(positionJsonStr);
        return positionJSONObj.getString("position");
    }

    //gets player's team from JSON
    public String getTeam(String teamJsonStr) throws JSONException {
        JSONObject teamJSONObj = new JSONObject(teamJsonStr);
        return teamJSONObj.getJSONObject("team").getString("full_name");
    }

    //gets player's division from JSON
    public String getDivision(String divisionJsonStr) throws JSONException {
        JSONObject divisionJSONObj = new JSONObject(divisionJsonStr);
        return divisionJSONObj.getJSONObject("team").getString("division");
    }

    //gets player's conference from JSON
    public String getConference(String conferenceJsonStr) throws JSONException {
        JSONObject conferenceJSONObj = new JSONObject(conferenceJsonStr);
        return conferenceJSONObj.getJSONObject("team").getString("conference");
    }
}

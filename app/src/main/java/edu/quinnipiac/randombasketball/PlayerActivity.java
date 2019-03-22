package edu.quinnipiac.randombasketball;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    Button returns;
    private ShareActionProvider shareActionProvider;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);

        returns = findViewById(R.id.backButton);

        //create a listener for the return button
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        //sets the name of the player textview to the first and last name from JSON
        String pName = (String) getIntent().getExtras().get("name");
        TextView playerName = findViewById(R.id.playerName);
        playerName.setText(playerName.getText() + pName);

        //sets the position of the player textview to the position from JSON
        String pPosition = (String) getIntent().getExtras().get("position");
        TextView playerPosition = findViewById(R.id.playerPos);
        playerPosition.setText(playerPosition.getText() + pPosition);

        //sets the team of the player textview to the team from JSON
        String pTeam = (String) getIntent().getExtras().get("team");
        TextView playerTeam = findViewById(R.id.playerTeam);
        playerTeam.setText(playerTeam.getText() + pTeam);

        //sets the division of the player textview to the division from JSON
        String pDivision = (String) getIntent().getExtras().get("division");
        TextView playerDivision = findViewById(R.id.playerDivision);
        playerDivision.setText(playerDivision.getText() + pDivision);

        //sets the conference of the player textview to the conference from JSON
        String pConference = (String) getIntent().getExtras().get("conference");
        TextView playerConference = findViewById(R.id.playerConf);
        playerConference.setText(playerConference.getText() + pConference);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Check out this player!");

        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                //make toast showing help text
                Toast.makeText(this,"Click the generate button to get a random player. Press return to get back to main menu and get a new player.",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                //change layout color to blue
                mRelativeLayout.setBackgroundColor(Color.BLUE);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

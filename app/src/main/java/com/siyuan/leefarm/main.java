package com.siyuan.leefarm;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class main extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
	    setupResources();
	    setupButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	void setupResources(){

	}

	void setupButtons(){
		final Button buttonCow = (Button)findViewById( R.id.button_cow );
		final Button buttonDog = (Button)findViewById( R.id.button_dog );
		final Button buttonDuck = (Button)findViewById( R.id.button_duck);
		final Button buttonAss = (Button)findViewById( R.id.button_ass );

		buttonCow.setOnClickListener( this );
		buttonDog.setOnClickListener( this );
		buttonDuck.setOnClickListener( this );
		buttonAss.setOnClickListener( this );
	}

	public void onClick(View v) {
		final int resID = getMediaResIdByButtonID( v.getId() );

		MediaPlayer mediaPlayer = getMediaPlayerByButtonID( v.getId(), resID );
		mediaPlayer.start();
	}

	int getMediaResIdByButtonID( final int buttonID ){
		switch ( buttonID ){
			case R.id.button_cow:   return R.raw.cow;
			case R.id.button_dog:   return R.raw.dog;
			case R.id.button_duck:  return R.raw.duck;
			case R.id.button_ass:   return R.raw.ass;
		}
		throw new IllegalArgumentException( "buttonID is not valid" );
	}

	MediaPlayer getMediaPlayerByButtonID( final int buttonID, final int resID ){
		int index = -1;
		switch ( buttonID ){
			case R.id.button_cow:   index = 0;  break;
			case R.id.button_dog:   index = 1;  break;
			case R.id.button_duck:  index = 2;  break;
			case R.id.button_ass:   index = 3;  break;
			default:
				throw new IllegalArgumentException( "buttonID is not valid" );
		}
		if( m_players[ index ] == null ){
			m_players[ index ] = MediaPlayer.create(this,resID);
		}
		return m_players[ index ];
	}

	MediaPlayer[] m_players = new MediaPlayer[4];

}

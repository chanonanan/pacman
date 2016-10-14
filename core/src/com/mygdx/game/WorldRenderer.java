package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	public static final int BLOCK_SIZE = 40;
	private SpriteBatch batch;
	private World world;
	private Texture pacmanImg;
	private Pacman pacman;
	private MazeRenderer mazeRenderer;
	private BitmapFont font;
	
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
	        this.pacmanGame = pacmanGame;
	        batch = pacmanGame.batch;
	        this.world = world;
	        pacmanImg = new Texture("pacman.png");
	        pacman = world.getPacman();
	        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
	        font = new BitmapFont();
	}
	public void render(float delta) {
		
		mazeRenderer.render();
        SpriteBatch batch = pacmanGame.batch;
        Vector2 pos = world.getPacman().getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
        PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        font.draw(batch, "" + world.getScore(), 700, 60);
        batch.end();
 }
	    
}

package com.lilithsthrone.game.character.body;

/**
 * @since 0.1.0
 * @version 0.1.95
 * @author Innoxia
 */
public enum CoverableArea {
	
	ASS("ass"),
	ANUS("asshole"),
	
	THIGHS("thighs"),
	
	VAGINA("pussy"),
	MOUND("mound"),
	PENIS("cock"),
	TESTICLES("balls"),
	
	BREASTS("breasts"),
	NIPPLES("nipples"),
	
	MOUTH("mouth");

	private String name;

	private CoverableArea(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

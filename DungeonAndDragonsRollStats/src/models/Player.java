package models;

import java.util.Map;

import enums.CharacterClass;
import enums.CharacterRace;

public class Player {
	private final CharacterClass characterClass;
	private final CharacterRace characterRace;
	private final String playerName;
	private final String characterName;
	private int startingLevel;
	private int maxHitDiceSize;
	private final Map<String, Integer> abilityStats;
	
	public CharacterClass getCharacterClass() {
		return this.characterClass;
	}
	
	public CharacterRace getCharacterRace() {
		return this.characterRace;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public String getCharacterName() {
		return this.characterName;
	}
	
	public int getStartingLevel() {
		return this.startingLevel;
	}
	
	public int getMaxHitDiceSize() {
		return this.maxHitDiceSize;
	}
	
	public Map<String, Integer> getAbilityStats() {
		return this.abilityStats;
	}
	
	private Player(
			CharacterClass characterClass, 
			CharacterRace characterRace,
			String playerName,
			String characterName,
			int startingLevel,
			int maxHitDiceSize,
			Map<String, Integer> abilityStats) {
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.playerName = playerName;
		this.characterName = characterName;
		this.startingLevel = startingLevel;
		this.maxHitDiceSize = maxHitDiceSize;
		this.abilityStats = abilityStats;
	}
	
	public class PlayerBuilder {
		private CharacterClass characterClass;
		private CharacterRace characterRace;
		private String playerName;
		private String characterName;
		private int startingLevel;
		private int maxHitDiceSize;
		private Map<String, Integer> abilityStats;
		
		public PlayerBuilder setCharacterClass(CharacterClass characterClass) {
			this.characterClass = characterClass;
			return this;
		}
		
		public PlayerBuilder setCharacterRace(CharacterRace characterRace) {
			this.characterRace = characterRace;
			return this;
		}
		
		public PlayerBuilder setPlayerName(String playerName) {
			this.playerName = playerName;
			return this;
		}
		
		public PlayerBuilder setCharacterName(String characterName) {
			this.characterName = characterName;
			return this;
		}
		
		public PlayerBuilder setStartingLevel(int startingLevel) {
			this.startingLevel = startingLevel;
			return this;
		}
		
		public PlayerBuilder setMaxhitDiceSize(int maxhitDiceSize) {
			this.maxHitDiceSize = maxhitDiceSize;
			return this;
		}
		
		public PlayerBuilder setAbilityStats(Map<String, Integer> abilityStats) {
			this.abilityStats = abilityStats;
			return this;
		}
		
		public Player build() {
			return new Player(characterClass, characterRace, playerName, characterName, startingLevel, maxHitDiceSize, abilityStats);
		}
	}
}

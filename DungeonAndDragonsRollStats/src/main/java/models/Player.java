package main.models;

import java.util.Map;
import java.util.Map.Entry;

import main.enums.CharacterClass;
import main.enums.CharacterRace;

public class Player {
	private final CharacterClass characterClass;
	private final CharacterRace characterRace;
	private final String playerName;
	private final String characterName;
	private int startingLevel;
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
	
	public Map<String, Integer> getAbilityStats() {
		return this.abilityStats;
	}
	
	private Player(
			CharacterClass characterClass, 
			CharacterRace characterRace,
			String playerName,
			String characterName,
			int startingLevel,
			Map<String, Integer> abilityStats) {
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.playerName = playerName;
		this.characterName = characterName;
		this.startingLevel = startingLevel;
		this.abilityStats = abilityStats;
	}
	
	public static class PlayerBuilder {
		private CharacterClass characterClass;
		private CharacterRace characterRace;
		private String playerName;
		private String characterName;
		private int startingLevel;
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
		
		public PlayerBuilder setAbilityStats(Map<String, Integer> abilityStats) {
			this.abilityStats = abilityStats;
			return this;
		}
		
		public Player build() {
			return new Player(characterClass, characterRace, playerName, characterName, startingLevel, abilityStats);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("=== DND Character Entry ===\n");
		s.append(String.format("Player Name: %s\n", this.getPlayerName()));
		s.append(String.format("Character Name: %s\n", this.getCharacterName()));
		s.append(String.format("Character Race: %s\n", this.getCharacterRace()));
		s.append(String.format("Character Class: %s\n", this.getCharacterClass()));
		s.append(String.format("Starting Level: %d\n", this.getStartingLevel()));
		s.append("Ability Stats: \n");
		
		for (Entry<String, Integer> abilityKeySet: this.getAbilityStats().entrySet()) {
			s.append(String.format("%s = %d\n", abilityKeySet.getKey(), abilityKeySet.getValue()));
		}
		
		return s.toString();
	}
}

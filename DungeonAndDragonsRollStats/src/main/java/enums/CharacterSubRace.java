package enums;

public enum CharacterSubRace {
	// dwarf
	HillDwarf,
	MountainDwarf,
	DuergarDwarf,
	// elf
	HighElf,
	WoodElf,
	DrowElf,
	EladrinElf,
	SeaElf,
	Shadar_Kai_Elf {
		@Override
		public String toString() {
			return "Shadar-Kai Elf";
		}
	},
	// gnome
	ForestGnome,
	RockGnome,
	SvirfneblinGnome,
	// aasimar
	ProtectorAasimar,
	ScourgeAasimar,
	FallenAasimar,
	// mousefolk
	MeadowguardMouseFolk,
	SoftpawMouseFolk,
	// halfling
	LightfootHalfling,
	StoutHalfling,
	GhostwiseHalfling,
	// aarakocra
	AirAarakocra,
	EarthAarakocra,
	FireAarakocra,
	WaterAarakocra,
	Regular,
	// genesi
	AirGenesi,
	EarthGenesi,
	FireGenesi,
	WaterGenesi,
	Variant
}

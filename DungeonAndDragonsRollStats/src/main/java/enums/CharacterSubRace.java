package enums;

enum CharacterSubRace {
	HillDwarf,
	MountainDwarf,
	DuergarDwarf,
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
	ForestGnome,
	RockGnome,
	SvirfneblinGnome,
	ProtectorAasimar,
	ScourgeAasimar,
	FallenAasimar,
	MeadowguardMouseFolk,
	SoftpawMouseFolk,
	LightfootHalfling,
	StoutHalfling,
	GhostwiseHalfling,
	AirAarakocra,
	EarthAarakocra,
	FireAarakocra,
	WaterAarakocra,
	Regular,
	Variant
	
	
}

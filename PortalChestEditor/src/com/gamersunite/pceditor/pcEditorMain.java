package com.gamersunite.pceditor;

import com.dd.plist.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class pcEditorMain extends JFrame {

	public int buttonsScale = 64;
	public static pcEditorMain my;
	
	public ArrayList<JButton> idButtons = new ArrayList<JButton>();
	public ArrayList<PortalChestItem> items = new ArrayList<PortalChestItem>();
	
	public String[] normals = {"CLOTHING", "UNKNOWN", "FLINT", "STICK", "FLINTAXE", "FLINTSPEAR", "FLINTPICKAXE", "DOUBLE-TIME", "TIMECRYSTAL", "BASKET", "EMBER", "CHARCOAL", "CAMPFIRE", "FLINTSPADE", "BASICTORCH", "BLOCKHEAD", "FOOD", "APPLE", "MANGO", "MAPLESEED", "PRICKLYPEAR", "FLINTMACHETE", "PINECONE", "CLAY", "RAWDODOMEAT", "DODOFEATHER", "COPPERORE", "IRONORE", "STONEAXE", "STONEPICKAXE", "COPPERINGOT", "TINORE", "TININGOT", "BRONZEINGOT", "COPPERSPEAR", "TINSPADE", "COPPERARROW", "COPPERBOW&ARROWS", "BRONZEPICKAXE", "STRING", "CLAYJUG", "COCONUT", "OILLANTERN", "OIL", "BRONZEMACHETE", "BRONZESWORD", "COAL", "WOODENDOOR", "LADDER", "FLAXSEED", "FLAX", "INDIANYELLOW", "REDOCHRE", "WINDOW", "COOKEDDODOMEAT", "ORANGE", "SUNFLOWERSEED", "CORN", "WOODENBED", "STONESPADE", "IRONINGOT", "IRONPICKAXE", "IRONMACHETE", "IRONSWORD", "TRAPDOOR", "IRONAXE", "CARROT", "GOLDINGOT", "GOLDNUGGET", "CARROTONASTICK", "RUBY", "EMERALD", "CHERRY", "COFFEECHERRY", "GREENCOFFEEBEAN", "CUP", "COFFEE", "ROASTEDCOFFEEBEAN", "LINEN", "LINENPANTS", "LINENSHIRT", "SAPPHIRE", "AMETHYST", "DIAMOND", "GOLDSPADE", "GOLDPICKAXE", "DODOEGG", "STEELINGOT", "STEELPICKAXE", "AMETHYSTPICKAXE", "SAPPHIREPICKAXE", "EMERALDPICKAXE", "RUBYPICKAXE", "DIAMONDPICKAXE", "ULTRAMARINEBLUE", "CARBONBLACK", "MARBLEWHITE", "TINBUCKET", "PAINT", "PAINTSTRIPPER", "BUCKETOFWATER", "PIGMENT", "EMERALDGREEN", "TYRIANPURPLE", "BOAT", "CHILLI", "LINENCAP", "LINENBRIMMEDHAT", "COPPERBLUE", "LEATHER", "FUR", "LEATHERJACKET", "LEATHERBOOTS", "FURCOAT", "FURBOOTS", "LEATHERPANTS", "CAMERA", "PORTAL", "AMETHYSTPORTAL", "SAPPHIREPORTAL", "EMERALDPORTAL", "RUBYPORTAL", "DIAMONDPORTAL", "SUNRISEHATOFFULLNESS", "SUNSETSKIRTOFHAPPINESS", "NORTHPOLEHATOFWARMTH", "SOUTHPOLEBOOTSOFSPEED", "KELP", "AMETHYSTCHANDELIER", "SAPPHIRECHANDELIER", "EMERALDCHANDELIER", "RUBYCHANDELIER", "DIAMONDCHANDELIER", "STEELLANTERN", "RAWFISH", "COOKEDFISH", "TINFOIL", "TINFOILHAT", "WORM", "FISHINGROD", "SHARKJAW", "FISHBUCKET", "SHARKBUCKET", "LIME", "SHELF", "TELEPORTHERE", "SIGN", "IRONDOOR", "IRONTRAPDOOR", "COPPERCOIN", "GOLDCOIN", "SHOP", "SOFTBED", "GOLDENBED", "BLACKWINDOW", "MAGNET", "COPPERBOILER", "ELECTRICMOTOR", "COPPERWIRE", "STEAMENGINE", "IRONPOT", "FISHCURRY", "DODOSTEW", "ICETORCH", "SILICONINGOT", "SILICONCRYSTAL", "SILICONWAFER", "TINARMORLEGGINGS", "TINCHESTPLATE", "TINHELMET", "TINBOOTS", "IRONARMORLEGGINGS", "IRONCHESTPLATE", "IRONHELMET", "IRONBOOTS", "ICEARMORLEGGINGS", "ICECHESTPLATE", "ICEHELMET", "ICEBOOTS", "RAIL", "TRAINSTATION", "PIGIRON", "CRUSHEDLIMESTONE", "TRAINWHEEL", "RAILHANDCAR", "STEAMLOCOMOTIVE", "FREIGHTCAR", "DISPLAYCABINET", "PASSENGERCAR", "CROWBAR", "TRADEPORTAL", "LARGESQUAREPAINTING", "LARGELANDSCAPEPAINTING", "LARGEPORTRAITPAINTING", "MEDSQUAREPAINTING", "MEDLANDSCAPEPAINTING", "MEDPORTRAITPAINTING", "SMALLSQUAREPAINTING", "SMALLLANDSCAPEPAINTING", "SMALLPORTRAITPAINTING", "EASEL", "STONECOLUMN", "LIMESTONECOLUMN", "MARBLECOLUMN", "SANDSTONECOLUMN", "REDMARBLECOLUMN", "LAPISLAZULICOLUMN", "BASALTCOLUMN", "STONESTAIRS", "LIMESTONESTAIRS", "MARBLESTAIRS", "SANDSTONESTAIRS", "REDMARBLESTAIRS", "LAPISLAZULISTAIRS", "BASALTSTAIRS", "COPPERCOLUMN", "TINCOLUMN", "BRONZECOLUMN", "IRONCOLUMN", "STEELCOLUMN", "GOLDCOLUMN", "WOODCOLUMN", "BRICKCOLUMN", "ICECOLUMN", "COPPERSTAIRS", "TINSTAIRS", "BRONZESTAIRS", "IRONSTAIRS", "STEELSTAIRS", "GOLDSTAIRS", "WOODSTAIRS", "BRICKSTAIRS", "ICESTAIRS", "STEELDOWNLIGHT", "POISON", "GOLDBOW&POISONARROWS", "STEELUPLIGHT", "WORLDCREDIT", "PLATINUMCOIN", "PLATINUMNUGGET", "PLATINUMINGOT", "PLATINUMSTAIRS", "PLATINUMCOLUMN", "GLASSSTAIRS", "GLASSCOLUMN", "BLACKGLASSSTAIRS", "BLACKGLASSCOLUMN", "FUEL", "REFINERY", "EPOXY", "RAWRESIN", "CARBONFIBERS", "CARBONFIBERSHEET", "CARBONFIBERWING", "JETPACKCHASSIS", "JETENGINE", "JETPACK", "TITANIUMORE", "TITANIUMINGOT", "TITANIUMSTAIRS", "TITANIUMCOLUMN", "CARBONFIBERSTAIRS", "CARBONFIBERCOLUMN", "TITANIUMPICKAXE", "TITANIUMSWORD", "TITANIUMLEGGINGS", "TITANIUMCHESTPLATE", "TITANIUMHELMET", "TITANIUMBOOTS", "CARBONFIBERLEGGINGS", "CARBONFIBERCHESTPLATE", "CARBONFIBERHELMET", "CARBONFIBERBOOTS", "VINE", "TULIPBULB", "TULIPSEED", "RANDOMORE", "ELECTRICSLUICE", "OWNERSHIPSIGN", "CAGE", "CAGEDDODO", "WOODENGATE", "AMETHYSTSHARD", "SAPPHIRESHARD", "EMERALDSHARD", "RUBYSHARD", "DIAMONDSHARD", "WHEAT", "FLOUR", "YEAST", "SALT", "DOUGH", "BREAD", "TOMATO", "PIZZA", "FLATBREAD", "MILK", "MOZZARELLA", "YAKHORN", "RAZOR", "YAKSHAVINGS", "CAGEDDONKEY", "CAGEDYAK", "CAGEDDROPBEAR", "CAGEDSCORPION", "RAINBOWCAKE", "RAINBOWESSENCE", "CAGEDUNICORN", "MIRROR", "PLASTERCOLUMN", "PLASTERSTAIRS", "AMETHYSTCOLUMN", "SAPPHIRECOLUMN", "EMERALDCOLUMN", "RUBYCOLUMN", "DIAMONDCOLUMN", "AMETHYSTSTAIRS", "SAPPHIRESTAIRS", "EMERALDSTAIRS", "RUBYSTAIRS", "DIAMONDSTAIRS", "STONE", "KILN", "REDBRICKS", "LIMESTONE", "MARBLE", "FURNACE", "WOODWORKBENCH", "TAILOR'SBENCH", "PRESS", "SANDSTONE", "REDMARBLE", "WOVENFLAXMAT", "YELLOWFLAXMAT", "REDFLAXMAT", "GLASS", "CHEST", "GOLDBLOCK", "ROCK", "DIRT", "WOOD", "WORKBENCH", "SAND", "TOOLBENCH", "LAPISLAZULI", "CRAFTBENCH", "MIXINGBENCH", "REINFORCEDPLATFORM", "ICE", "DYEBENCH", "COMPOST", "BASALT", "SAFE", "COPPERBLOCK", "TINBLOCK", "BRONZEBLOCK", "IRONBLOCK", "STEELBLOCK", "METALWORKBENCH", "GOLDENCHEST", "PORTALCHEST", "BLACKSAND", "BLACKGLASS", "STEAMGENERATOR", "ELECTRICKILN", "ELECTRICFURNACE", "ELECTRICMETALWORKBENCH", "ELECTRICSTOVE", "SOLARPANEL", "FLYWHEEL", "ARMORBENCH", "TRAINYARD", "BUILDER'SBENCH", "ELEVATORSHAFT", "ELECTRICELEVATORMOTOR", "PLATINUMBLOCK", "CARBONFIBERBLOCK", "TITANIUMBLOCK", "ELECTRICPRESS", "GRAVEL", "COMPOSTBIN", "EGGEXTRACTOR", "PIZZAOVEN", "AMETHYSTBLOCK", "SAPPHIREBLOCK", "EMERALDBLOCK", "RUBYBLOCK", "DIAMONDBLOCK", "PLASTER", "FEEDERCHEST", "LUMINOUSPLASTER"};
	
	public String[] hexes = {"1", "0x12a", "3", "4", "6", "7", "8", "9", "0xb", "0xc", "0xd", "0xe", "0xf", "0x10", "0x11", "0x13", "0x14", "0x15", "0x16", "0x17", "0x18", "0x19", "0x1b", "0x1c", "0x1d", "0x1e", "0x1f", "0x20", "0x21", "0x22", "0x23", "0x24", "0x25", "0x26", "0x27", "0x28", "0x29", "0x2a", "0x2b", "0x2c", "0x2d", "0x2e", "0x2f", "0x30", "0x31", "0x32", "0x33", "0x34", "0x35", "0x36", "0x37", "0x38", "0x39", "0x3a", "0x3b", "0x3c", "0x3d", "0x3e", "0x3f", "0x40", "0x41", "0x42", "0x43", "0x44", "0x45", "0x46", "0x47", "0x48", "0x49", "0x4a", "0x4b", "0x4c", "0x4d", "0x4e", "0x4f", "0x50", "0x51", "0x52", "0x53", "0x54", "0x55", "0x56", "0x57", "0x58", "0x59", "0x5a", "0x5b", "0x5c", "0x5d", "0x5e", "0x5f", "0x60", "0x61", "0x62", "99", "100", "0x65", "0x66", "0x67", "0x68", "0x69", "0x6a", "0x6d", "0x6e", "0x6f", "0x70", "0x73", "0x75", "0x77", "0x78", "0x79", "0x7a", "0x7c", "0x7e", "0x7f", "0x82", "0x85", "0x86", "0x87", "0x88", "0x89", "0x8a", "0x8b", "0x8c", "0x8d", "0x8e", "0x8f", "0x90", "0x91", "0x92", "0x93", "0x94", "0x95", "0x96", "0x97", "0x98", "0x99", "0x9a", "0x9b", "0x9c", "0x9d", "0x9e", "0x9f", "0xa0", "0xa1", "0xa2", "0xa3", "0xa4", "0xa5", "0xa6", "0xa7", "0xa8", "0xa9", "0xaa", "0xae", "0xaf", "0xb0", "0xb1", "0xb2", "0xb3", "0xb4", "0xb5", "0xb6", "0xb7", "0xb8", "0xb9", "0xba", "0xbb", "0xbc", "0xbd", "0xbe", "0xbf", "0xc0", "0xc1", "0xc2", "0xc3", "0xc4", "0xc5", "0xc6", "199", "200", "0xc9", "0xca", "0xcb", "0xcc", "0xcd", "0xce", "0xcf", "0xd0", "0xd1", "0xd2", "0xd4", "0xd5", "0xd6", "0xd7", "0xd8", "0xd9", "0xda", "0xdb", "0xdc", "0xdd", "0xde", "0xdf", "0xe0", "0xe1", "0xe2", "0xe3", "0xe4", "0xe5", "0xe6", "0xe7", "0xe8", "0xe9", "0xea", "0xeb", "0xec", "0xed", "0xee", "0xef", "0xf0", "0xf1", "0xf2", "0xf3", "0xf4", "0xf5", "0xf6", "0xf7", "0xf8", "0xf9", "0xfa", "0xfb", "0xfc", "0xfd", "0xfe", "0xff", "0x101", "0x102", "0x103", "0x104", "0x105", "0x106", "0x107", "0x108", "0x109", "0x10a", "0x10b", "0x10c", "0x10d", "0x10e", "0x10f", "0x110", "0x111", "0x112", "0x113", "0x114", "0x115", "0x116", "0x117", "0x118", "0x119", "0x11a", "0x11b", "0x11c", "0x11d", "0x11e", "0x11f", "0x120", "0x121", "0x122", "0x123", "0x124", "0x125", "0x126", "0x127", "0x128", "0x129", "299", "300", "0x12d", "0x12e", "0x12f", "0x130", "0x131", "0x132", "0x133", "0x134", "0x135", "0x136", "0x137", "0x138", "0x139", "0x13a", "0x13b", "0x13c", "0x13d", "0x13e", "0x13f", "0x140", "0x141", "0x142", "0x143", "0x144", "0x145", "0x146", "0x147", "0x148", "0x149", "0x14a", "0x14b", "0x14c", "0x14d", "0x14e", "0x14f", "0x150", "0x151", "0x152", "0x153", "0x154", "0x155", "0x156", "0x157", "0x400", "0x401", "0x402", "0x404", "0x406", "0x407", "0x408", "0x409", "0x40a", "0x40c", "0x40e", "0x40f", "0x410", "0x411", "0x412", "0x413", "0x415", "0x417", "0x418", "0x419", "0x41a", "0x41b", "0x41c", "0x41e", "0x41f", "0x420", "0x421", "0x424", "0x425", "0x426", "0x428", "0x429", "0x42a", "0x42b", "0x42c", "0x42d", "0x42e", "0x42f", "0x430", "0x432", "0x433", "0x434", "0x435", "0x436", "0x437", "0x438", "0x439", "0x43a", "0x43b", "0x43c", "0x43d", "0x43e", "0x43f", "0x440", "0x441", "0x442", "0x443", "0x445", "0x446", "0x447", "0x448", "0x449", "0x44a", "1099", "0x44c", "0x44d", "0x44e", "0x44f", "0x450", "0x451"};
	
	public pcEditorMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		JLabel title = new JLabel("Portal Chest Editor for The Blockheads");
		add(title);
		for (int i = 0; i < 4*4; i++) {
			idButtons.add(null);
			items.add(null);
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JButton b = new JButton("0");
				b.setLayout(null);
				b.setBounds(i*buttonsScale,j*buttonsScale,buttonsScale,buttonsScale);
				final int a = i;
				final int d = j;
				b.addActionListener(e ->
				{
				    new pcEditorItemEditor((a)+(d*4), Integer.valueOf(b.getText()), items.get(a+(d*4)).itemName);
				});
				idButtons.set((a)+(d*4), b);
				items.set((a)+(d*4), new PortalChestItem());
				add(b);
			}
		}
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(0, (buttonsScale*4), (buttonsScale*4), 48);
		JButton helpBtn = new JButton("Help");
		helpBtn.setBounds(0, (buttonsScale*4)+48, (buttonsScale*4), 48);
		saveBtn.addActionListener(e ->
		{
			System.out.println("Exiting program, saving portal chest data to portalChest");
			try {
				NSDictionary root = new NSDictionary();
				NSArray items = new NSArray(16);
				for (int i = 0; i < 16; i++) {
					PortalChestItem pci = this.items.get(i);
					//System.out.println(pci.count);
					final int theCount = pci.count;
					NSArray theArray = new NSArray(theCount);
					items.setValue(i, theArray);
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						int the = (j)+(i*4);
						/*System.out.println("---");
						//
						System.out.print("i: ");
						System.out.println(i);
						//
						System.out.print("j: ");
						System.out.println(j);
						//
						System.out.print("the: ");
						System.out.println(the);*/
						PortalChestItem pci = this.items.get(the);
						final int theCount = pci.count;
						if (theCount > 0) {
							NSArray theArray = (NSArray)items.objectAtIndex(the);
							NSData data = new NSData(pci.BlockheadsItemData());
							for (int c = 0; c < theCount; c++) {
								theArray.setValue(c, data);
							}
						}
					}
				}
				root.put("saveItemSlots", items);
				BinaryPropertyListWriter.write(root, new File("portalChest"));
			} catch(Exception exc) {
				System.out.println("Unable to save portal chest plist!");
				exc.printStackTrace();
			}
			setVisible(false);
			dispose();
		});
		helpBtn.addActionListener(e ->
		{
			JOptionPane.showMessageDialog(this, "Click the buttons to edit the slots!\n\nThe text is equal to the count set in the slot.\n\n0 means no object will be set.", "Help", JOptionPane.PLAIN_MESSAGE);
		});
		add(saveBtn);
		add(helpBtn);
		setTitle("Portal Chest Editor");
		setSize(buttonsScale*4, (buttonsScale*4)+((48*2)+24));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("Loading program");
		my = new pcEditorMain();
	}

}

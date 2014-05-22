package com.example.bookit;

import java.util.HashMap;

public class Books {
	
	private HashMap<String,String> BookLinks;
	private HashMap<String,String> BookTitle;
	private HashMap<String,String> BookImageNames;
	
	
	/**
	 * The Constructor loads all the books into the hashmap for quick access to
	 * links, images, etc based on the id.
	 */
	public Books(){
		
		this.BookImageNames = new HashMap<String,String>();
		this.BookLinks = new HashMap<String,String>();
		this.BookTitle = new HashMap<String,String>();
		
		loadBooks();
	}
	
	/**
	 * Load the default set of books into the hashmaps.
	 */
	private void loadBooks(){
		String aisn = "0262182629";
		String link = "http://www.amazon.com/Processing-Programming-Handbook-Designers-Artists/dp/0262182629%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0262182629";
		String title = "Processing Programming Handbook";
		String imageName = "0262182629.jpg";
		
		AddBook(aisn,link,title,imageName);
				
		aisn = "0465018475"; 
		link = "http://www.amazon.com/Surfaces-Essences-Analogy-Fuel-Thinking/dp/0465018475%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0465018475";
		title = "Surfaces Essences Analogy Fuel Thinking";
		imageName = "0465018475.jpg";
		AddBook(aisn,link,title,imageName);
		
		aisn = "0387310738";
		link = "http://www.amazon.com/Pattern-Recognition-Learning-Information-Statistics/dp/0387310738%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0387310738";
		title = "Pattern Recognition Learning Information Statistics";
		imageName = "0387310738.jpg";
		
		AddBook(aisn,link,title,imageName);
		
		aisn ="1581604947";
		link ="http://www.amazon.com/The-Ultimate-Sniper-Advanced-Training/dp/1581604947%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1581604947"; 
		title = "The Ultimate Sniper Advanced Training";
		imageName = "1581604947.jpg";
		aisn ="0385495323"; 
		link = "http://www.amazon.com/The-Code-Book-Science-Cryptography/dp/0385495323%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0385495323"; 
		title = "The Code Book Science Cryptography";
		imageName = "0385495323.jpg";
		aisn ="0262013193"; 
		link = "http://www.amazon.com/Probabilistic-Graphical-Models-Principles-Computation/dp/0262013193%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0262013193"; 
		title = "Probabilistic Graphical Models";
		imageName = "0262013193.jpg";
		aisn ="1591846900"; 
		link = "http://www.amazon.com/Big-Bang-Disruption-Devastating-Innovation/dp/1591846900%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1591846900"; 
		title = "Big Bang Disruption Devastating Innovation";
		imageName = "1591846900.jpg";
		aisn ="0321767535"; 
		link = "http://www.amazon.com/Things-Designer-People-Voices-Matter/dp/0321767535%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0321767535"; 
		title = "Things Designer People Voices Matter";
		imageName = "0321767535.jpg";
		aisn ="1133958494"; 
		link = "http://www.amazon.com/Sensation-Perception-CourseMate-Printed-Access/dp/1133958494%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1133958494"; 
		title = "Sensation Perception Course";
		imageName = "1133958494.jpg";
		aisn ="0743222091"; 
		link = "http://www.amazon.com/Diffusion-Innovations-Edition-Everett-Rogers/dp/0743222091%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0743222091"; 
		title = "Diffusion Inovations";
		imageName = "0743222091.jpg";
		aisn ="0140067485"; link = "http://www.amazon.com/The-Puzzle-Palace-Intelligence-Organization/dp/0140067485%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0140067485"; 
		title = "The Puzzle Palace";imageName = "0140067485.jpg";

		aisn ="0471603856"; link = "http://www.amazon.com/Seeing-Light-Optics-Photography-Holography/dp/0471603856%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0471603856"; 
		title = "Seeing Light Optics Photography";imageName = "0471603856";
		
		aisn ="0321605780"; link = "http://www.amazon.com/Agile-Product-Management-Scrum-Addison-Wesley/dp/0321605780%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0321605780"; 
		title = "Agile Product Management";imageName = "0321605780";
		
		aisn ="0761917527"; link = "http://www.amazon.com/Images-Organization-The-Executive-Edition/dp/0761917527%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0761917527"; 
		title = "Images Organization"; imageName = "0761917527";
		
		aisn ="0679735666"; link = "http://www.amazon.com/Natural-History-Senses-Diane-Ackerman/dp/0679735666%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0679735666"; 
		title = "Natural History Senses";imageName = "0679735666";
		
		aisn ="4805311290"; link = "http://www.amazon.com/Geek-Japan-Discovering-Manga-Ceremony/dp/4805311290%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D4805311290"; 
		title = "Geek Japan Discovering Manga Ceremony";imageName = "4805311290";
		
		aisn ="0470665769"; link = "http://www.amazon.com/Interaction-Design-Beyond-Human-Computer/dp/0470665769%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0470665769"; 
		title = "Interaction Design Beyond Human Computer";imageName = "0470665769";
		
		aisn ="076454280X"; link = "http://www.amazon.com/The-Art-Deception-Controlling-Security/dp/076454280X%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D076454280X"; 
		title = "The Art of Deception - controlling security";imageName = "076454280X";
		
		aisn ="1400068711"; link = "http://www.amazon.com/The-Age-Insight-Understand-Unconscious/dp/1400068711%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1400068711"; 
		title = "The Age Insight"; imageName = "1400068711";
		
		aisn ="1118549368"; link = "http://www.amazon.com/Exploring-Arduino-Techniques-Engineering-Wizardry/dp/1118549368%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1118549368"; 
		title = "Exploring Ardunio Techniques";imageName = "1118549368";
		
		aisn ="0765334380"; link = "http://www.amazon.com/Pillar-Sky-William-R-Forstchen/dp/0765334380%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0765334380"; 
		title = "Pillar Sky";imageName = "0765334380";
		
		aisn ="1452202990"; link = "http://www.amazon.com/Mass-Communication-Living-Opinion-Edition/dp/1452202990%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1452202990"; 
		title = "MassCommunication-Living Opinion";imageName = "1452202990";
		
		aisn ="1556433417"; link = "http://www.amazon.com/Relearning-See-Improve-Eyesight-Naturally/dp/1556433417%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1556433417"; 
		title = "Relearning";imageName = "1556433417";
		
		aisn ="1601631898"; link = "http://www.amazon.com/The-Big-Book-Barbara-Mitchell/dp/1601631898%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1601631898"; 
		title = "The Big Book";imageName = "1601631898";
		
		aisn ="0123736021"; link = "http://www.amazon.com/Learning-Processing-Beginners-Programming-Interaction/dp/0123736021%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0123736021"; 
		title = "Learning Processing - Beginners Programming";imageName = "0123736021";
		
		aisn ="1621365328"; link = "http://www.amazon.com/Spiritual-Avalanche-Teachings-Destroy-Millions/dp/1621365328%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1621365328"; 
		title = "Spiritual Avalanche";imageName = "1621365328";
		
		aisn ="0321898656"; link = "http://www.amazon.com/Data-Just-Right-Introduction-Addison-Wesley/dp/0321898656%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0321898656"; 
		title = "Data Just Right"; imageName = "0321898656";
		
		aisn ="0451417704"; link = "http://www.amazon.com/Kill-Decision-Daniel-Suarez/dp/0451417704%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0451417704"; 
		title = "Kill Decision";imageName = "0451417704";
		
		aisn ="1595588671"; link = "http://www.amazon.com/Digital-Disconnect-Capitalism-Internet-Democracy/dp/1595588671%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1595588671"; 
		title = "Digital Disconnect - Capitalism; Internet; Democracy";imageName = "1595588671";
		
		aisn ="1477809783"; link = "http://www.amazon.com/Terms-Enlistment-Frontlines-Marko-Kloos/dp/1477809783%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1477809783"; 
		title = "Terms Enlistment Frontlines";imageName = "1477809783";
		
		aisn ="0465026567"; link = "http://www.amazon.com/G%C3%B6del-Escher-Bach-Eternal-Golden/dp/0465026567%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0465026567"; 
		title = "Escher";imageName = "0465026567";
		
		aisn ="0393334775"; link = "http://www.amazon.com/How-Mind-Works-Steven-Pinker/dp/0393334775%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0393334775"; 
		title = "How the Mind Works";imageName = "0393334775";
		
		aisn ="1118795482"; link = "http://www.amazon.com/Raspberry-User-Guide-Eben-Upton/dp/1118795482%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1118795482"; 
		title = "Rasberry pi User Guide";imageName = "1118795482";
		
		aisn ="B00BJEA5J2"; link = "http://www.amazon.com/Shades-Children-Garth-Nix/dp/B00BJEA5J2%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB00BJEA5J2"; 
		title = "Shades of Children";imageName = "B00BJEA5J2";
		
		aisn ="0062128256"; link = "http://www.amazon.com/Haunted-Empire-Apple-After-Steve/dp/0062128256%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0062128256"; 
		title = "Haunted Empire";imageName = "0062128256";
		
		aisn ="0123814642"; link = "http://www.amazon.com/Information-Visualization-Third-Edition-Technologies/dp/0123814642%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0123814642"; 
		title = "Information Visualization";imageName = "0123814642";
		
		aisn ="0062120999"; link = "http://www.amazon.com/Great-Choice-Uncertainty-Luck-Why-Despite/dp/0062120999%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0062120999"; 
		title = "Great Choice Uncertainty Luck Why Despite";imageName = "0062120999";
		
		aisn ="0307887898"; link = "http://www.amazon.com/The-Lean-Startup-Entrepreneurs-Continuous/dp/0307887898%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0307887898"; 
		title = "The Lean Startup";imageName = "0307887898";
		
		aisn ="1610393090"; link = "http://www.amazon.com/Unleashing-Second-American-Century-Dominance/dp/1610393090%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1610393090"; 
		title = "Unleashing the Second American Century";imageName = "1610393090";
		
		aisn ="0982634811"; link = "http://www.amazon.com/Interdisciplinary-Interaction-Design-Interactive-Experiences/dp/0982634811%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0982634811"; 
		title = "Interdisciplinary Interaction Design";imageName = "0982634811";
		
		aisn ="0307472256"; link = "http://www.amazon.com/Subliminal-Unconscious-Rules-Behavior-Vintage/dp/0307472256%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0307472256"; 
		title = "Subliminal";imageName = "0307472256";
		
		aisn ="0123814790"; link = "http://www.amazon.com/Data-Mining-Concepts-Techniques-Management/dp/0123814790%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0123814790"; 
		title = "Data Mining Concepts and Techniques";imageName = "0123814790";
		
		aisn ="0307588696"; link = "http://www.amazon.com/Kingpin-Hacker-Billion-Dollar-Cybercrime-Underground/dp/0307588696%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0307588696"; 
		title = "Kingpin Hacker Billion Dollar Cybercrime";imageName = "0307588696";
		
		aisn ="0124166725"; link = "http://www.amazon.com/Cyber-Warfare-Second-Edition-Practitioners/dp/0124166725%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0124166725"; 
		title = "Cyber Warfare";imageName = "0124166725";
		
		aisn ="1934938750"; link = "http://www.amazon.com/Eye-Yoga-How-You-Think/dp/1934938750%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1934938750"; 
		title = "Eye Yoga"; imageName = "1934938750";
		
		aisn ="0470531290"; link = "http://www.amazon.com/Contemporary-Business-Louis-E-Boone/dp/0470531290%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0470531290"; 
		title = "Contemporary Business";imageName = "0470531290";
		
		aisn ="0452298776"; link = "http://www.amazon.com/100-Diagrams-That-Changed-World/dp/0452298776%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0452298776"; 
		title = "100 Diagrams that Changed the World";imageName =  "0452298776";
		
		aisn ="1449356435"; link = "http://www.amazon.com/Zero-Maker-Learn-Enough-Anything/dp/1449356435%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1449356435"; 
		title = "Zero Maker Learn Enough";imageName =  "1449356435";
		
		aisn ="1422102823"; link = "http://www.amazon.com/The-Medici-Effect-Elephants-Innovation/dp/1422102823%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1422102823"; 
		title = "The Medici";imageName = "1422102823";
		
		aisn ="1599791773"; link = "http://www.amazon.com/Commanding-Your-Morning-Unleash-Power/dp/1599791773%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1599791773"; 
		title = "Commanding Your Morning";imageName = "1599791773";
		
		aisn ="038553082X"; link = "http://www.amazon.com/The-Future-Mind-Scientific-Understand/dp/038553082X%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D038553082X"; 
		title = "The Future Mind";imageName =  "038553082X";
		
		aisn ="0324302592"; link = "http://www.amazon.com/Management-Challenges-Tomorrows-InfoTrac-1-Semester/dp/0324302592%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0324302592"; 
		title = "Management Challenges";imageName = "0324302592";
		
		aisn ="0465046746"; link = "http://www.amazon.com/Mindstorms-Children-Computers-Powerful-Ideas/dp/0465046746%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0465046746"; 
		title = "Mindstorms";imageName = "0465046746";
		
		aisn ="007174875X"; link = "http://www.amazon.com/The-Innovation-Secrets-Steve-Jobs/dp/007174875X%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D007174875X"; 
		title = "The Innovation Secrets";imageName = "007174875X";
		
		aisn ="0071750363"; link = "http://www.amazon.com/Robot-Builders-Bonanza-4th-Edition/dp/0071750363%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0071750363"; 
		title = "Robot Builders Bonanza";imageName = "0071750363";
		
		aisn ="1119998956"; link = "http://www.amazon.com/Design-Hackers-Reverse-Engineering-Beauty/dp/1119998956%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1119998956"; 
		title = "Design Hackers Reverse Engineering"; imageName = "1119998956";
		
		aisn ="0385517254"; link = "http://www.amazon.com/The-Fifth-Discipline-Practice-Organization/dp/0385517254%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0385517254"; 
		title = "The Fifth Discipline";imageName = "0385517254";
		
		aisn ="0840033559"; link = "http://www.amazon.com/Cognitive-Psychology-Connecting-Research-Experience/dp/0840033559%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0840033559"; 
		title = "Cognitive Psychology"; imageName = "0840033559";
		
		aisn ="0195321057"; link = "http://www.amazon.com/How-Read-Film-Movies-Beyond/dp/0195321057%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0195321057"; 
		title = "How Read Films"; imageName = "0195321057";
		
		aisn ="0495601497"; link = "http://www.amazon.com/Sensation-Perception-E-Bruce-Goldstein/dp/0495601497%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0495601497"; 
		title = "Sensation Perception";imageName = "0495601497";
		
		aisn ="012375030X"; link = "http://www.amazon.com/Designing-Mind-Simple-Understanding-Interface/dp/012375030X%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D012375030X"; 
		title = "Designing Mind Simple Understanding";imageName = "012375030X";
		
		aisn ="1449388396"; link = "http://www.amazon.com/Hackers-Computer-Revolution-Anniversary-Edition/dp/1449388396%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1449388396"; 
		title = "Hackers Computer Revolution";imageName = "1449388396";
		
		aisn ="0393239357"; link = "http://www.amazon.com/The-Second-Machine-Age-Technologies/dp/0393239357%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0393239357"; 
		title = "The Second Machine Age";imageName = "0393239357";
		
		aisn ="0062093029"; link = "http://www.amazon.com/Vortex-Insignia-S-J-Kincaid/dp/0062093029%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0062093029"; 
		title = "Vortex Insignia";imageName = "0062093029";
		
		aisn ="0071413774"; link = "http://www.amazon.com/Finance-Non-Financial-Managers-Briefcase-Series/dp/0071413774%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0071413774"; 
		title = "Finance";imageName = "0071413774";
		
		aisn ="1591843065"; link = "http://www.amazon.com/The-Back-Napkin-Expanded-Edition/dp/1591843065%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1591843065"; 
		title = "The Back Napkin";imageName = "1591843065";
		
		aisn ="0312622376"; link = "http://www.amazon.com/Our-Final-Invention-Artificial-Intelligence/dp/0312622376%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0312622376"; 
		title = "Our Final Invention - Artificial Intelligence";imageName = "0312622376";
		
		aisn ="0062093002"; link = "http://www.amazon.com/Insignia-S-J-Kincaid/dp/0062093002%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0062093002"; 
		title = "Insignia";imageName = "0062093002";
		
		aisn ="0521314194"; link = "http://www.amazon.com/Human-Error-James-Reason/dp/0521314194%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0521314194"; 
		title = "Human Error";imageName = "0521314194";
		
		aisn ="048624864X"; link = "http://www.amazon.com/Introduction-Artificial-Intelligence-Enlarged-Mathematics/dp/048624864X%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D048624864X"; 
		title = "Introduction to Artificial Intelligence";imageName = 
		
		aisn ="1118291980"; link = "http://www.amazon.com/Contemporary-Business-Louis-E-Boone/dp/1118291980%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1118291980"; 
		title = "Contemporary Business";imageName = "1118291980";
		
		aisn ="0525953736"; link = "http://www.amazon.com/Average-Is-Over-Powering-Stagnation/dp/0525953736%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0525953736"; 
		title = "Average is Over";imageName = "0525953736";
		
		aisn ="1416537805"; link = "http://www.amazon.com/Dragon-Dirk-Adventure-Clive-Cussler/dp/1416537805%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1416537805"; 
		title = "Dragon";imageName = "1416537805";
		
		aisn ="0393330435"; link = "http://www.amazon.com/iWoz-Computer-Invented-Personal-Co-Founded/dp/0393330435%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0393330435"; 
		title = "iWoz";imageName = "0393330435";
		
		aisn ="0544002695"; link = "http://www.amazon.com/Big-Data-Revolution-Transform-Think/dp/0544002695%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0544002695"; 
		title = "Big Data";imageName = "0544002695";
		
		aisn ="1451648537"; link = "http://www.amazon.com/Steve-Jobs-Walter-Isaacson/dp/1451648537%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1451648537"; 
		title = "Steve Jobs";imageName = "1451648537";
		
		aisn ="1598571966"; link = "http://www.amazon.com/Augmentative-Alternative-Communication-Supporting-Children/dp/1598571966%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1598571966"; 
		title = "Augmentative Alternative Communication";imageName = "1598571966";
		
		aisn ="0393048136"; link = "http://www.amazon.com/The-New-Thing-Silicon-Valley/dp/0393048136%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0393048136"; 
		title = "The new thing - Silicon Valley";imageName = "0393048136";
		
		aisn ="0060008768"; link = "http://www.amazon.com/The-Difference-Between-Larry-Ellison/dp/0060008768%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0060008768"; 
		title = "The Difference Between";imageName = "0060008768";
		
		aisn ="0688177883"; link = "http://www.amazon.com/The-Scientist-Crib-Early-Learning/dp/0688177883%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0688177883"; 
		title = "The Scientist Crib";imageName = "0688177883";
		
		aisn ="1426208081"; link = "http://www.amazon.com/The-Science-Book-Everything-About/dp/1426208081%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1426208081"; 
		title = "The Science Book";imageName = "1426208081";
		
		aisn ="0385484992"; link = "http://www.amazon.com/Visions-Science-Will-Revolutionize-Century/dp/0385484992%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0385484992"; 
		title = "Visions Science will Revolutionize the Century";imageName = "0385484992";
		
		aisn ="1118717058"; link = "http://www.amazon.com/Learning-Python-Raspberry-Alex-Bradbury/dp/1118717058%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1118717058"; 
		title = "Learning Python Raspberry";imageName = "1118717058.jpg";
		
		aisn ="0201633612"; link = "http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0201633612"; 
		title = "Design Patterns";imageName = "0201633612.jpg";
		
		aisn ="1782161406"; link = "http://www.amazon.com/Building-Machine-Learning-Systems-Python/dp/1782161406%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1782161406"; 
		title = "Building Machine Learning Systems";imageName = "1782161406.jpg";
		
		aisn ="1137278463"; link = "http://www.amazon.com/Zero-Marginal-Cost-Society-Collaborative/dp/1137278463%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1137278463"; 
		title = "Zero Marginal Cost";imageName = "1137278463.jpg";
		
		aisn ="1416609407"; link = "http://www.amazon.com/Curriculum-21-Essential-Education-Changing/dp/1416609407%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1416609407"; 
		title = "Curriculum";imageName = "1416609407.jpg";
		
		aisn ="0071704426"; link = "http://www.amazon.com/Mechanisms-Mechanical-Devices-Sourcebook-Edition/dp/0071704426%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0071704426"; 
		title = "Mechanisms of Mechanical Devices";imageName = "0071704426.jpg";
		
		aisn ="0262134748"; link = "http://www.amazon.com/Designing-Interactions-Bill-Moggridge/dp/0262134748%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0262134748"; 
		title = "Designing Interactions";imageName = "0262134748.jpg";
		
		aisn ="0307390993"; link = "http://www.amazon.com/The-Master-Switch-Information-Empires/dp/0307390993%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0307390993"; 
		title = "The Master Switch";imageName = "0307390993.jpg";
		
		aisn ="0756637589"; link = "http://www.amazon.com/Merriam-Webster-Childrens-Dictionary-DK-Publishing/dp/0756637589%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0756637589"; 
		title = "Merriam Webster Childrens Dictionary";imageName = "0756637589.jpg";
		
		aisn ="0671657135"; link = "http://www.amazon.com/The-Society-Mind-Marvin-Minsky/dp/0671657135%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0671657135"; 
		title = "The Society Mind";imageName = "0671657135.jpg";
		
		aisn ="0262018020"; link = "http://www.amazon.com/Machine-Learning-Probabilistic-Perspective-Computation/dp/0262018020%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0262018020"; 
		title = "Machine Learning Probabilistic Perspective";imageName = "0262018020.jpg";
		
		aisn ="1449344216"; link = "http://www.amazon.com/Getting-Started-Raspberry-Pi-Make/dp/1449344216%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1449344216"; 
		title = "Getting Started with Raspberry Pi";imageName = "1449344216.jpg";
		
		aisn ="1107422221"; link = "http://www.amazon.com/Machine-Learning-Science-Algorithms-Sense/dp/1107422221%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1107422221"; 
		title = "Machine Learning Science Algorithms";imageName = "1107422221.jpg";
		
		aisn ="1449307078"; link = "http://www.amazon.com/Making-Things-See-Processing-MakerBot/dp/1449307078%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1449307078"; 
		title = "Making things see";imageName = "1449307078.jpg";
		
		aisn ="0307887189"; link = "http://www.amazon.com/Dark-Pools-Machine-Traders-Rigging/dp/0307887189%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0307887189"; 
		title = "Dark Pools Machine Traders";imageName = "0307887189.jpg";
		
		aisn ="0385260946"; link = "http://www.amazon.com/The-Fifth-Discipline-Peter-Senge/dp/0385260946%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0385260946"; 
		title = "The Fifth Discipline";imageName = "0385260946.jpg";
		
		aisn ="1451659253"; link = "http://www.amazon.com/Inside-Box-Creativity-Breakthrough-Results/dp/1451659253%3FSubscriptionId%3DAKIAJMFW6F37ROWP7LQA%26tag%3Dwwwbarkanidoc-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1451659253"; 
		title = "Inside Box Creativity";imageName = "1451659253.jpg";
		
		aisn ="B000PC0S7I"; link = "http://www.amazon.com/gp/reader/B000PC0S7I";
		title = "The Greatest Story Ever Sold";imageName = "B000PC0S7I";
	}
	
	
	/**
	 * Using the AISN, add the book to the hashmaps. 
	 * @param AISN
	 * @param link
	 * @param title
	 * @param imageName
	 */
	public void AddBook(String AISN, String link, String title, String imageName){
		
		
		
//		this.BookImageNames.put(AISN,imageName);
//		this.BookTitle.put(AISN, title);
//		this.BookLinks.put(AISN, link);		
	}
	
	/**
	 * Get the amazon link for the given AISN.
	 * @param AISN
	 * @return
	 */
	public String GetBookLink(String AISN){
		return this.BookLinks.get(AISN);
	}
	
	/**
	 * Get the name of the image which corresponds to the given AISN.
	 * @param AISN
	 * @return
	 */
	public String GetBookImageName(String AISN){
		return this.BookImageNames.get(AISN);
	}

	/**
	 * Get the title of the book corresponding to the given AISN.
	 * @param AISN
	 * @return
	 */
	public String GetBookTitle(String AISN){
		return this.BookTitle.get(AISN);
	}
}

package com.jeversoft.android.sqlite.first;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_OFFPRINTS = "offprints";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_COMMENT = "offprints";

  private static final String DATABASE_NAME = "offprints.db";
  private static final int DATABASE_VERSION = 6;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_OFFPRINTS + "(" + COLUMN_ID
      + " integer primary key autoincrement, "
	  + " author varchar(100),"
      + " title varchar(200),"
	  + " year int,"
      + " proceedings varchar(4),"
	  + " copies varchar(5),"
	  + " pages int,"
      + " _raw varchar(330));";

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
	  try {		  
    database.execSQL(DATABASE_CREATE);
    populateDb(database);
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	  try {		  
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFPRINTS);
    onCreate(db);
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }
  
  public ContentValues setUpOffPrintInsert(String Author,String Title,int Year,String Proceedings,String Copies,int Pages) {
  ContentValues contentValues1 = new ContentValues();
  contentValues1.put("author", Author);
  contentValues1.put("title",Title);
  contentValues1.put("year",Year);
  contentValues1.put("proceedings",Proceedings);
  contentValues1.put("copies", Copies);
  contentValues1.put("pages", Pages);
  contentValues1.put("_raw", Author.toLowerCase() + " " + Title.toLowerCase() + " " + Integer.toString(Year) + " " +Proceedings.toLowerCase() + " " + Copies.toLowerCase() + " " + Integer.toString(Pages));
  return contentValues1;   
  }
 

	public void storeOffPrint(SQLiteDatabase db, ContentValues contentValues){

  try {
        db.insertOrThrow("offprints", null, contentValues);
   } catch (Exception e) {
       System.out.print(e.getMessage());
   }

 }


  private void populateDb(SQLiteDatabase db){
	   ContentValues contentValues = new ContentValues();

	   contentValues = setUpOffPrintInsert("Allan, J.","The excavation of a Brewhouse at Buckland Abbey in 2005",2006,"64","12",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J.","The Ringing chamber floor of the tower of St Mary''s Church, Axminster  ",2005,"63","37",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J.","An Angel from Pinhoe and other Medieval English Alabasters from Devon",2001,"59","8",22);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J.","Medieval pottery and the dating of deserted settlements on Dartmoor",1994,"52","69",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J., Blackmore, S. & Passmore, A.","Archaeological Investigations around Crediton Parish Church 1984-2007",2010,"68","6",56);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J., Durrant J. and Taylor, R.","Roman Tiles in Exminster Church",2008,"66","26",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J., Higham, R.A. and Young, G.","The Medieval Chapel at Fardel Manor, Cornwood, and its Context",2008,"66","34",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J., Austin, J. and Collins, A.G.","Observations on the Site of Cowick Priory, Exeter",2008,"66","31",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Young, G.","Excavation at Kenton parish church in 2006",2007,"65","40",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Wakeham, C.","The tower and spire of St Mary''s Church, Diptford ",2007,"65","41",80);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. Cramp, C. & Horner, B.","The Post-Medieval pottery at Castle Hill, Great Torrington, North Devon ",2007,"65","27",46);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Young, G.","The refectory range of Kerswell Priory",2006,"64","20",44);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Blaylock, S.","Medieval pottery and other finds from Pigs Paradise, Lundy",2005,"63","18",15);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Dyer, M.","The Medieval Gatehouse of the  Chancellor''s House, Cathedral Close Exeter",2005,"63","24",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. Horner, B. & Langman, G.","Seventeenth-Eighteenth-Century pottery waste from the Stella Maris Convent School site, Bideford",2005,"63","15",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. Langman, G.","A group of Medieval Pottery from Haycroft Farm, Membury",2002,"60","23",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allan, J. & Richards, M.","A Lantern fragment from Exmouth",1998,"56","29",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allen, M.J. Moore, C. &Scaife, R. G.","The geoarchaeology of the alluvium in the Taw Valley west of Barnstaple",2004,"62","29",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Allen, M.J., Cameron, N. Clapham, A.J. Scaife","The Environment of a Neolithic Palaeochannel and the sediments History of the Torridge at New Road Bideford Devon",2012,"70","46",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("ApSimon, A.","The Bronze Age pottery from Ash Hole, Brixham, Devon",1968,"26","22",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Barnett, C. Scaife, R. & Cooke, N.","Iron Age to Saxon landscape and landuse change in the Taw Valley: Evidence from an infilled River channel at Little Pill Far, Sticklepath Hill near Barnstaple",1968,"26","42",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Bayley, J.","Precious Metal Refining in Roman Britain",2001,"59","16",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Berridge, P.","A flint collection from Hedgemoor Farm, Bridford",2007,"65","28",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Berridge, P.","A Mesolithic site on Bolberry Down",1984,"42","24",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Berridge, P. & Simpson, S.","The Mesolithic, Neolithic and early Bronze Age site at Bulleigh Meadow, Marldon",1992,"50","12",18);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Besley, E.","The Exeter mint, 1643-1646",1992,"50","98",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Blaylock, S.R.","Exeter Guildhall",1990,"48","49",55);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Blaylock, S.R.","A survey of Greenway''s porch at St. Peter’s Church, Tiverton",1986,"44","31",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Bosanko, J.","The archaeological achievement, 1929-1979",1980,"38","40",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Bridgewater, R. & Miles, T.","A trial excavation at Kigbeare, Okehampton Hamlets",1978,"36","64",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown.S","Leigh Barton, Churchstow, Devon",1998,"56","18",96);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown, S.","Excavations at Plympton Priory in 1988",1989,"47","26",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown, S.","Excavations and building recording at Buckfast Abbey, Devon",1988,"46","59",76);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown, S.","The medieval bridge and St. Gabriel''s Chapel, Bishop''s Clyst",1982,"40","22",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown, S.","The medieval Larkbeare Bridge, Exeter",1981,"39","6",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Brown, S. & Laithwaite, M.","Northwood Farm, Christow: an abandoned farmstead on the eastern fringe of Dartmoor",1993,"51","3",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Cannan, F.","Rediscovering a medieval mural in the church of St Michael, Axmouth",2007,"65","32",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Caseldine, C. & Hatton, J.","Into the mists? Thoughts on the prehistoric and historic environmental history of Dartmoor",1994,"52","40",12);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Chandler, B.","A Late Romano-British Inhumation Burial from Hockhills Paignton",2008,"66","48",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Cain, C. Valentin, J.","Part of a Prehistoric Ring Ditch and two Post Roman Corn Drying Ovens on Land at oaklands Cowick Lane Exeter",2011,"69","19",18);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Cole, M. & Linford, N.","The geophysical survey at Woodbury Farm, Axminster",1993,"51","13",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Collis, J.","Field systems and boundaries on Shaugh Moor and at Wotter, Dartmoor",1983,"41","1",15);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Collings, A.G., Reed, S.J. Stead, P. & Allan, J.","The medieval Moated Site at the Gardener''s Arms, Wonford, Exeter",2010,"68","36",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Cramp, C.","Medieval and post medieval Floor tiles Weare Gifford Church, North devon",2012,"70","8",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Cramp, C.","A North-Devon fireback and spit-support from Appledore",2003,"61","40",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Davin, R.","The chantry at Burston",1995,"53","27",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Dyer, M. & Allan, J.","An excavation on the defences of the Anglo-Saxon Burh and medieval town of Totnes",2004,"62","17",25);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Dyer, M. & Allan, J.","A newly-recorded length of Exeter''s medieval and later water supply",2004,"62","32",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Farnell, A. Quinnell, H.","Further Prehistoric Activity at Town Farm Quarry Burlescombe ",2012,"70","40",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Farnell, A.","A Pit at Crosslands, Ipplepen",2010,"68","10+",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Exeter Excavation Committee","Report on the Excavations of 1934-35",1935,"2 pt 3","44",17);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Field, J.","Excavations at St. Andrew''s Street and West Exe, Tiverton",1977,"35","26",17);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Field, J. & Miles, H.","An upper Palaeolithic site at Honiton",1975,"33","29",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fleming, A.","The reaves reviewed",1994,"52","59",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fleming, A.","Medieval and post-medieval cultivation on Dartmoor: a landscape archaeologist''s view",1994,"52","72",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fleming, A.","Devon Early Roads",2012,"70","50",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fletcher.M","Woodbury Castle: an earthwork survey by the RCHME",1998,"56","20",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fox,H.","Medieval Dartmoor as seen through its account rolls",1994,"52","73",22);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Fox, A.","The Retreat Topsham",1991,"49","4",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gallant, L.","Torwood Mount",1976,"34","15",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gallant, L. Luxon, N. & Coleman, M.","Ancient fields on the South Devon limestone plateau",1985,"43","4",15);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gaskell Brown, C.","Buckland Abbey",1995,"53","31",57);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gent, T.","Post medieval beach Burials at Croyde Bay",2011,"69","",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gent, T.","Bronze Age burnt mounds and early medieval wells at Town Farm Quarry, Burlescombe",2007,"65","38",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gent, T.","The re-excavation of a deserted medieval longhouse at Hutholes, Widecombe in the Moor, Dartmoor",2007,"65","37",35);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gent,T.H. & Quinnell,H.","Salvage Recording Neolithic site at Haldon Belvedere",1999,"57","18",27);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gent,T.H. & Quinnell,H.","Excavations of Causeway Enclosure & Hillfort Raddon Hill Stockleigh Pomeroy",1999,"57","10",75);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gerrard, S.","The Dartmoor tin industry: an archaeological perspective",1994,"52","58",25);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gibson, A.","The excavation of an Iron Age settlement at Gold Park, Dartmoor",1992,"50","14",27);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gilbert, D.","A Bronze Age Enclosure with extramural Structures and Field Systems on Land to the North of Old Rydon Lane Exeter",2012,"70","48",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gillings, M. Taylor, J.","Geophysical Survey and Excavation at the Exmoor Stone Setting of Furzehill Common",2011,"69","39",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Gillard, M., Quinnell, H.","Prehistoric Activity and Artefacts at the Donkey Sanctuary, Trow Farm, Salcomber Regis, Devon",2012,"70","48",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Grant, N.","The occupation of hillforts in Devon during the late Roman and Post-Roman periods",1995,"53","9",12);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Green, T.","Excavation of a Hillslope Enclosure at Holworthy Farm, Parracombe displaying Bronze Age and Iron Age Activity ",2009,"67","62",33);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Greeves, T., Quinnell, H. & Taylor, R.","Neolithic Sherda and Prehistoric Lithics from Merrivale",2010,"68","33",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Greeves, T. & Newman, P.","Tin-working and land-use in the Walkham Valley: a preliminary analysis",1994,"52","40",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffiths, D.","'A field to the spoiler'': a review of archaeological conservation on Dartmoor",1994,"52","70",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffiths, D, & Griffith, F.","An excavation at 39 Fore Street, Totnes",1984,"42","2",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith, F.M.","Changing perceptions of the context of prehistoric Dartmoor",1994,"52","61",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith, F.M.","Salvage observations at the Dark Age site at Bantham Ham, Thurlestone, in 1982",1986,"44","8",18);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith, F.M.","Trial excavation of a ring cairn at Rixdale, Mamhead",1984,"42","43",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith, F.M.","Aerial reconnaissance in Devon in 1984: a preliminary report and the discovery of a hillfort",1984,"42","6",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith, F.M.","The identification of four new enclosure sites north of Teignmouth",1983,"41","12",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Griffith.F.M.& Reed, S.J.","Rescue Recording at Bantham Ham, South Devon, in 1997",1998,"56","3",22);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Hatton, J.H. & Caseldine, C.J.","Vegetation change and land use history during the first millennium AD at Aller Farm, East Devon,",1991,"49","23",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Hearne, C. & Seager Smith, R","A middle Iron Age and Roman site at Aller Cross, Kingskerswell, 1993",1995,"53","19",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Henderson,C.G.","The Development of the South Gate of Exeter and its role in the City''s defences",2001,"59","83",78);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Henderson, C.G. & Weddell, P","Medieval settlements on Dartmoor and in west Devon: the evidence from excavations",1994,"52","35",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R. Henderson, C.G.","Danes Castle, Exeter: Excavations 1992-3",2011,"69","20",23);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R.","Excavations at Okehampton Castle, Devon. Part 1: the motte and keep",1977,"35","20",40);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R.","Devon Castle Studies: a Personal Reflection. Devon Archaeological Society Presidential lecture 2009",2009,"67","77",27);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R. & Hamlin, A.","Bampton Castle, Devon: history and archaeology",1990,"48","1",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R. & Goddard, S.","Great Torrington Castle",1987,"45","12",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Higham, R. Goddard, S & Rouillard, M.","Plympton Castle, Devon",1985,"43","2",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Hood, A.","Late iron Age and early Roman Settlement at Willand Road, Cullompton",2010,"68","77",22);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Holbrook, N.","Trial excavations at Honeyditches, Seaton and the nature of the Roman occupation",1987,"45","18",15);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Holbrook, N. & Fox, A.","Excavations in the legionary fortress at Bartholomew Street East, Exeter, 1959",1987,"45","2",34);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Hunt, A.","  An Earthwork Survey of Dunkeswell Abbey ",2000,"58","4",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Jarvis, K.","The M5 motorway and the Peamore-Pocombe link",1976,"34","18",31);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Jones, A.","Gallows Execution Sites",2008,"66","26",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Jones, A.M. and Quinnell, H.","The Farway Barrow Complex in east Devon Reassessed",2008,"66","23",30);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Laithwaite, M., Blaylock, S.R., and Westcott, K.A.","The Bishop''s Palace at Bishopsteignton",1989,"47","5",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Leivers, M.","Investigation of a Late Mesolithic site at Little Pill Farm, Sticklepath Hill, near Barnstaple",2007,"65","45",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Leverett, M., Quinnell, H.","An Early Neolithic Assemblage from Wayland, Tiverton",2011,"69","32",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Manning, P. and Quinnell, H.","Excavations and field survey at the Iron Age hillfort at Berry Ball, Crediton Hamlets",2009,"67","19",33);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Marchand, J.","'A high rock called Crockern Tot'",1995,"53","26",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Mathews, A.J. Collings, A.G. Allan, J.","The Ship Inn: a Row of Late medieval Houses in St Martin''s Lane, Exeter",2011,"69","30",34);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Mayes, A. Hardy, A.","Excavations on the Site of Bonhay Mills Exeter",2004,"62","14",27);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Maxfield, V.A.","Tiverton Roman fort (Bolham); excavations 1981-1986",1991,"49","1",65);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Maxfield, V.A.","Devon and the end of the Fosse Frontier",1986,"44","4",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Maxfield, V.A,","Excavations at Ashbury in 1983, with a note on Broadbury Castle",1985,"43","18",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Maxfield, V.A.","Aileen Fox: a bibliography 1934-1979",1979,"37","2",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Mayes, A. & Hardy, A.","Excavations on the site of Bonhay Mills Exeter 2000-1",2004,"62","32",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("McAleer, J.","The façade of the Romanesque cathedral at Exeter",1984,"42","29",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Miles, H.","The A38 roadworks",1977,"35","21",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Miles, H. & Miles, T.","Pilton, North Devon: excavations within a medieval village",1975,"33","36",29);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Miles, T.","The excavation of a Saxon cemetery and part of the Norman castle at North Walk, Barnstaple",1986,"44","15",25);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Newberry, J.","Inland flint in Prehistoric Devon: sources, tool-making quality and use",2002,"60","4",36);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Newberry, J. & Pearce, N.","A Mesolithic lithic scatter from Abbotsham Court, North Devon",2005,"63","8",32);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Newman, P.","Eylesbarrow (Ailsborough) tin mine",1999,"57","12",43);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Newman, P. & Salvatore, J.P.","An emergency coast artillery battery at Battery Gardens, Brixham, Torbay",2003,"61","12",22);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Nicholson, O.","The Romans and the Long Causeway at Tiverton",1995,"53","7",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Archaeological records of a 17th century house at 144 Fore Street, Exeter",2001,"59","19",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","No. 94 Vauxhall Street: an Early 19th –Century Office and Warehouse on Plymouth''s Waterfront",2009,"67","48",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Nos 53-53a Southside Street: A merchant''s house in Plymouth ",2007,"65","33",54);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Archaeological recording at No. 67 South Street, Exeter ",2004,"62","22",31);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Archaeological recording at the Malthouse, Haven Banks, Exeter",2003,"61","20",63);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Almshouse",2002,"60","23",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R.","Archaeological recording of a 17th century House at 144 Fore Street, Exeter",2001,"59","22",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R. Collings, A.G. & Passmore, A.J.","The Admiral Vernon Inn, Alphington",2010,"68","42",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R. Allan, J., Fletcher, M., Higham, R. & Laithwaite, M.","The Bishop''s Palace at Chudleigh ",2006,"64","28",48);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R. & Collings, A.G. ","The historic buildings and tenurial history of No. 2 Broadgate, Exeter",2006,"64","28",76);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker, R. & Collings, A. ","St Catherine''s Almshouses and Medieval Canonry in Catherine Street, Exeter",2002,"60","30",130);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Parker Pearson, M.","A Neolithic and Bronze Age Site at Churston, South Devon",1981,"39","12",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Passmore, A. J., Jones, P. and Allan, J.","Dyers, Fullers and Brewers: Post-Medieval Housing and Industries at Tudor Street, Exeter.",2009,"67","10",62);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Passmore, A.J.","A 19th century railway Turntable at the Canal Basin Exeter",2011,"69","30",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Passmore, A.  ","A Roman Enclosure and probable Roman trackway at Newland Mill, North Tawton ",2005,"63","46",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pattison, P.","Oldstone: a mansion and its gardens in South Devon. A survey by the Royal Commission on the Historical Monuments of England",1992,"50","23",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pattison, P. & Fletcher, M","Grimspound, one hundred years on",1994,"52","45",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pearse","RN Stores Exeter",2011,"69","7",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pearce, S.","Church and society in South Devon, AD 350-700",1982,"40","4",12);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pearce, S.","Bronze Age pottery from barrows at Berrynarbor, Nymet Tracey and Lovehayne",1973,"31","17",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Piggott, S.","South-west England – north-west Europe: contrasts and contacts in prehistory",1979,"37","10",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pollard, S.","A late Iron Age settlement and a Romano-British villa at Holcombe, near Uplyme, Devon",1974,"32","14",102);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pollard, S.","Seven prehistoric sites near Honiton, Devon. Part 1. A Beaker flint ring and three cairns",1967,"25","1",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pollard, S. & Luxton, S.","Neolithic and Bronze Age occupation on Salcombe Hill, Sidmouth",1978,"36","31",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pollard, S. & Russell, P","Radiocarbon dating. Excavation of round barrow 248b, Upton Pyne, Exeter",1976,"34","16",2);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Preese, P. Steinmetzer, M. Quinnell, H.","An early Neolithic Pit alignment, Grooved ware, and Bronze Age field boundaries at the former royal navy Stores depot, Old Rydon Lane, Exeter",2011,"69","43",30);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Preece, C.","Bottle seals from North Devon: a review",2008,"66","68",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Preece, C.","A conflict of interests: the fish traps of the Taw and Torridge estuaries ",2005,"63","17",26);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Preece, C.","Evidence for high status at sea: the Church Rocks wreck",2004,"62","0",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Preece, C. and Thompson, P.","A Cache of early Clay Pipes from Appledore",2009,"67","10+",1);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Probert, S. & Dunn, C.","Denbury Camp, Torbryan Parish: a new survey by the Royal Commission on the Historical Monuments of England",1992,"50","17",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pye, A.","An example of a non-metalliferous Dartmoor industry: the gunpowder factory at Powdermills",1994,"52","28",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pye, A.","Bideford town quay",1992,"50","35",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pye, A.","An archaeological survey of Mount Pleasant Redoubt, Plymouth",1992,"50","5",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Pye, A. & Dixon, T.","The arsenic works at Devon Great Consols Mine",1989,"47","1",32);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinn, G.","A new survey of the prehistoric field system on Kerswell Down and Whilborough Common",1995,"53","39",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","Prehistoric and Roman material from Lundy",2010,"68","50",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","Devon Beakers: New finds, new thoughts",2003,"61","18",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","Excavations of an Exmoor barrow and ring cairn",1997,"55","30",38);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","New perspectives on upland monuments – Dartmoor in earlier prehistory",1994,"52","58",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","Becoming marginal ? Dartmoor in later prehistory",1994,"52","109",7);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","Excavations of hut circles at Heatree, Manaton in 1968 1991",1991,"49","0",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H.","The local character of the Devon bronze Age and its interpretation in the 1980s",1988,"46","6",12);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H. Reed, S.","Archaeology and the Branscombe to Gatcombe Water Pipeline, East Devon",2012,"70","",20);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Quinnell, H. & Taylor, R.","A Peterborough Sherd from the beach at Westward Ho ",2007,"65","37",2);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Radford, C.","Tiles and other objects found at Frithelstock Priory",1935,"2 pt 3","3",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Rainbird.P","Oldaport and the Anglo-Saxon defence of Devon",1998,"56","33",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Rainbird, P & Druce, D.","A late Saxon date from Oldaport ",2004,"62","59",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Ravenhill, W.","Archaeology and cartography",1990,"48","6",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Ravenhill, W.","Aileen Fox: an appreciation",1979,"37","20",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Reed, S.J.","Evaluation excavations of Post-Roman features at Wembury Bay near Plymouth",2005,"63","37",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Reed, S.J. Juleff, G. & Bayer, O.J.","Three Late Saxon iron-smelting furnaces at Burlescombe, Devon ",2006,"64","19",34);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Reed, S.J. & Turton, S.D.","Archaeological investigations at the possible site of Ipplepen Priory, Silver Street, Ipplepen",2006,"64","25",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Reed, S.J. & Manning, P.T.  ","Archaeological Recording of a Hillslope Enclosure at North Hill Cleave, Bittadon, North Devon",2000,"58","5",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Riley, H.","Holne Chase Castle, Holne, Devon: a new survey by the Royal Commission on the Historical Monuments of England",1995,"53","22",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Robinson, R. & Greeves,T.","Two unrecorded prehistoric multiple stone rings, Glasscombe, Ugborough, South Dartmoor",1981,"39","8",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Sage, H & Allan, J.","The early Roman military defenses, late Roman burials and later",2004,"62","33",39);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Salvatore, J.P., Quinnell, H.","Excavation of a Bronze Age roundhouse and other prehistoric Romano British and early Medieval features at the Language Energy Centre and Par, and the Choakfors langage pipeline Sparkwell, South hams",2001,"69","21",44);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Salvatore, J.P.","Three Roman Military Cremation Burials from Holloway Street, Exeter",2001,"59","20",24);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Salvatore, J.P.","Road North Tawton",1982,"49","2",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Salvatore, J.P.","Pipe Line Sparkwell",1982,"49","10",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Sheridan, A., Schulting, R., Quinnell, H. and Taylor, R.","Revisiting a small passage Tomb at Broadsands, Devon",2008,"66","48",26);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Silvester, R.","The later prehistoric and Roman material from Kent''s cavern, Torquay",1986,"44","11",29);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Silvester, R.","An excavation at Dunkeswell",1980,"38","17",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Silvester, R. & Quinnell, N","Unfinished hillforts on the Devon moors",1993,"51","28",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Silvester, R., Berridge, P. & Uglow, J.","A fieldwalking exercise on Mesolithic and Neolithic sites at Nether Exe",1987,"45","54",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Silvester, R & Bidwell, P","A Roman Site at Woodbury, Axminster",1984,"42","25",23);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Simpson, S. & Griffith, F","Trial excavation at the Roman fort on St Andrew''s Hill, Cullompton",1993,"51","6",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Simpson, S., Griffith, F. & Holbrook, N.","The prehistoric, Roman and early post-Roman sit at Hayes Farm, Clyst Honiton",1989,"47","3",28);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Smith, E.","A Neolithic long barrow at Uplowman Road, Tiverton",1990,"48","7",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Smith, P. et al.","The investigation of a medieval shell midden in Braunton Burrows",1983,"41","19",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Straker, V, Robinson, M. & Robinson, E.","Biological investigations of waterlogged deposits in the roman fortress ditch at Exeter",1984,"42","24",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Tabor, R. ","A Medieval Building and metal Working debris on land to the East of Castle Dene Hemyock",2010,"68","48",10);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Taylor, J.","Colaton Raleigh Gold bracelet hoard and its significance",1999,"57","36",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Thorpe, J.R.L.","The Construction Presentation and Development of a Merchant''s Town House North Devon",2012,"70","",103);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Thorp, J.","The Quay, Dartmouth: a Devon town house of 1664",1983,"41","6",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Thorp, J.","Two hall houses from a late medieval terrace: 8-12 Fore Street, Silverton",1982,"40","4",9);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Thorpe, J. & Cox, J.","The traditional Dartmoor farmhouse: the end",1994,"52","65",28);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Tilley, C.","Jacob’s Well, Black Hill: a Bronze Age Water Shrine on Woodbury Common",2009,"67","17",74);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Timms, S.","'Deep Breathing to Grimspound'': archaeologists discover Dartmoor",1994,"52","88",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Timms, S.","From Ancient Monuments to Historic Landscapes: the quest to conserve Devon''s Archaeological Heritage",1993,"51","44",16);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Tingle, M.","Re-Used Memorials at St Peter''s Church Ugborough, Devon",2011,"69","38",8);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Tingle, M.","Excavations of a possible Causewayed Enclosure and Roman",2006,"64","15",52);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","A Greek Coin from Colyford",2009,"67","10",1);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","A Neolithic site on St John''s Hill, Honiton ",2005,"63","18",6);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","The Roman Fort and later Roman site at Bury Barton ",2002,"60","21",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","The Cross-Dykes at Hembury ",2002,"60","7",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd. M","A hillslope enclosure at Rudge, Morchard Bishop",1998,"56","57",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","The hillfort of Dumpdon",1992,"50","24",5);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Todd, M.","A lost gold object from Uplyme",1984,"42","37",2);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Trevarthen, M.","Mount Foundry, Tavistock: An Early 19th century Iron and Brass Foundry in West Devon",2009,"67","24",30);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Turner, J.","Ring cairns, stone circles and related monuments on Dartmoor",1990,"48","72",59);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Turner, J.","A possible henge at Teignhead",1984,"42","39",3);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Turner, S. & Gerrard, J. ","Imported and local pottery from Mothercombe: Some new finds amongst old material in Totnes Museum",2004,"62","32",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wainwright, G.J.","A pit burial at Lower Ashmore Farm, Rose Ash, Devon",1980,"38","24",2);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wallis","Iron Age Round House East Wrolington",2012,"70","38",0);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Watts,M. & Quinnell, H.","A Bronze Age Cemetery at Elburton, Plymouth",2001,"59","21",32);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.J.","  The Excavation of a Post-Roman Cemetery Near Kenn ",2000,"58","1",30);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.","Archaeological recording in the medieval borough of Newport, Barnstaple, in 1983",1990,"48","28",11);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.","Excavations within the Anglo-Saxon enclosure at Berry Meadow, Kingsteignton, in 1985",1987,"45","22",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.","The excavation of medieval and later houses and St. Margaret''s Chapel at Exmouth, 1982-1984",1986,"44","37",21);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.","Excavations at Southgate Cottages, Lydford",1981,"39","13",34);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P.","Excavations at 3-5 Lower Fore Street, Exmouth",1980,"38","11",38);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P. & Reed, S.","Excavations at Sourton Down Okehampton 1986-1991: Roman road, deserted hamlet and other landscape features",1997,"55","27",136);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Weddell, P. & Westcott, K","The Bovey Tracey pottery kilns",1986,"44","10",19);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Westcott, K.","The spire and roofs of Hatherleigh Church: investigations following the storm damage of 1990",1992,"50","60",28);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wheeler, J. & Laing-Trengrove, D.","A Roman tile kiln on Hatherleigh Moor and the sources of some Roman tile in Devon",2006,"64","24",18);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wilson-North, R.","Bampton Castle: an earthwork survey by the Royal Commission on the Historical Monuments of England",1991,"49","10",4);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wilson-North, R. & Dunn, C.","'The Rings', Loddiswell: a new survey by the Royal Commission on Historical Monuments, England",1990,"48","10",13);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Wilson-North, R.","A Burnt Mound on Brendon Common, Exmoor",2011,"69","10",14);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Whybrow, C. ","Some multivallate hillforts on Exmoor and in North Devon",1967,"25","1",18);
	   storeOffPrint(db, contentValues);
	   contentValues = setUpOffPrintInsert("Woods, R. ","The Romanesque font at St Marychurch, Torquay ",2004,"62","29",19);
	   storeOffPrint(db, contentValues);
  }
} 
#Tutorial Card Library


A simple library to run a tutorial within an android application.

##Usage

Create an ArrayList of TutorialEntry objects.

Each object contains an image to display to the user and a message to explain
the image content.

    ArrayList<TutorialEntry> entries=new ArrayList<TutorialEntry>();
    entries.add(new TutorialEntry(R.drawable.something,"Hello World!"));

Put this object in a bundle and pass the bundle with a message of
"entries". Start an intent of TutorialCardActivity with the bundle of entries
present.

    Intent intent=new Intent(this, TutorialCardActivity.class);
    intent.putExtra("entries",entries);
    startActivity(intent);



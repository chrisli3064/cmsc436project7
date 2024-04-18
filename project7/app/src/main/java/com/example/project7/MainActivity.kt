package com.example.project7
//Joseph Yi, Christopher Li, Mudit Mathur, Bhargav Tumkur
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.InputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var factory : SAXParserFactory = SAXParserFactory.newInstance()
        var saxParser : SAXParser = factory.newSAXParser()

        var handler: SAXHandler = SAXHandler()
        val BALLOONID = R.raw.balloons1
        var iStream : InputStream = resources.openRawResource(BALLOONID)

        saxParser.parse(iStream, handler)

        var balloons: ArrayList<Balloon> = handler.getItems()
        for (balloon in balloons)
            Log.w( "MainActivity", balloon.toString() )

    }

}
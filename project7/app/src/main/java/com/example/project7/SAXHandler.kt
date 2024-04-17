package com.example.project7

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class SAXHandler : DefaultHandler() {

    private var listOfItems : ArrayList<Balloon> = ArrayList<Balloon>()
    private var currentElement : String = ""
    private var currentItem : Balloon? = null
    private var validText : Boolean = false

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        super.startElement(uri, localName, qName, attributes)
        // Log.w( "MainActivity", "start element is " + localName )
        validText = true
        if( qName != null ) {
            currentElement = qName
            if( currentElement.equals( "item" ) )
                currentItem = Balloon( "", "" )
        }

    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        // Log.w( "MainActivity", "end element is " + localName )

        validText = false
        if( qName.equals( "item" ) && currentItem != null )
            listOfItems.add( currentItem!! )
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        if( ch != null ) {
            var s: String = String(ch!!, start, length)
            // Log.w("MainActivity", "characters are " + s)

            if( validText && currentItem != null ) {
                if( currentElement.equals( "title" ) )
                    currentItem!!.Balloon( s )
                else if( currentElement.equals( "link" ) )
                    currentItem!!.setLink( s )
            }
        }
    }

    fun getItems( ) : ArrayList<Item> {
        return listOfItems
    }

}
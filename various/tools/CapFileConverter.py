#! /usr/bin/python
# -*- coding: utf8 -*-
#
# Convert JAR CAP Files to CAP Files with Java Card specification 3.0
#
# author : Guillaume BOUFFARD
# Revision 1.0
# Tuesday April 21 
#

import os
import re
import sys
import os.path
import commands

def convertCapFile ( in_, out ) :
	# Simple case
	#extract CAP files contient by the zip file
	re_unzip = re.compile(r"\s+\d+\s+[\d\-]+\s+[\d\:]+\s+([\w\/\.]+)")

	if in_[-3:] != "cap":
		return

	print "Convert JAR " + in_ + " --> " + out
	list_output = commands.getstatusoutput("unzip -l " + in_);
	if list_output[0] != 0 :
		print "[ERROR] Can't list files in JAR file " + in_
		#sys.exit(0)
	else :
		#print "début de l'analyse"
		
		MyFiles = list_output[1].split("\n")

		capfilename = []
		for l in MyFiles:

			listfiles = re_unzip.search(l)
			
			if listfiles:
				files = listfiles.groups()
				for f in files:
					file = f.split("/")
					#print file
					# Java Card specification 3.0 says the components do in <PACKAGE>/javacard/
					if ( file[-2] == "javacard") and ( file[-1] != "") and (file[-1][-3:] == "cap"):
						capfilename.append ( file[-1] )
		#print capfilename

		#print "Extract " + sys.argv [ 1 ]
		extract_output = commands.getstatusoutput("unzip -bjd tmp/ " + in_ );
		#print "End of extraction"
		if extract_output[0] != 0 :
			print "[ERROR] Can't extract JAR file : " + in_ + "\n" + extract_output[1] 
			#sys.exit(0)
		else :
			#Save list of file with new path
			fileslist = ""
			#print capfilename
			for f in capfilename :
				fileslist += "tmp/" + f + " "
			
			#print "Concatenate files"
			if os.path.exists(out):
				commands.getoutput("rm -f " + out )
			else:
				lfolder = out.split("/")
				path = ""
				for f in lfolder[0:-1]:
					path += f + "/"
				if path:
					commands.getoutput("mkdir -p " + path)
			
			#print ">>" + str ( fileslist )
			cat_output = commands.getstatusoutput("cat " + fileslist + " > " + out );
			if cat_output[0] != 0 :
				print "[ERROR] Can't concatenate files"
				sys.exit(0)
			else:
				#print "End of concatenation"
				commands.getoutput ( "rm -rf tmp/" )

def FolderCheck ( in_ , out ):
	ls_output = commands.getstatusoutput("ls " + in_)

	if ls_output[0] != 0 :
	    print "[ERROR] Can't list files in " + out + " folder" 
	else :
		if out[-1] != "/":
			out += "/"

		if in_[-1] != "/":
			in_ += "/"

		lpath = in_.split("/")
		#path = ""

		# save path
		#for p in lpath[0:-1]:
		#	path += p + "/"

		list = ls_output[1].split("\n")
		
		if not list[0] :
			return

		for f in list :
			if os.path.isfile(in_ + f): #f is a file
				convertCapFile(in_+f , out+f)
			elif os.path.isdir(in_+f): #f is a directory
				FolderCheck(in_+f , out+f)
			else:
				print "[ERROR] " + in_ + f + " : unknow type"
				sys.exit(0)

# Check if arguments number is correct
if ( ( len ( sys.argv ) - 1 ) == 3 ) :
	print "USAGE : CapFileManipulator.py <JAR CAP FILES FOLDER/FILE> <NEW CAP FILES FOLDER/FILE>"
	exit ( 0 )

#Check type
if ( not ( os.path.exists ( sys.argv [ 1 ] ) ) ) :
	print "USAGE : CapFileManipulator.py <JAR CAP FILES FOLDER/FILE> <NEW CAP FILES FOLDER/FILE>"
	exit ( 0 )

old = sys.argv [ 1 ]
new = sys.argv [ 2 ]

try :

	if ( os.path.isfile ( sys.argv [ 1 ] ) ) :
		# Simple case
		#extract CAP files contient by the zip file
		convertCapFile ( old , new )

	else :
		FolderCheck( old , new )

except Exception , message :
	print message

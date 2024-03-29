/*
 * This file is part of Biblio.
 *
 *     Biblio is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Biblio is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Biblio.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.loftjob.model;

public class HTMLConstants {

	public final static String CSS_MAIN_STYLE = "<style type=\"text/css\">\n"+
			"html,\n" + 
			"body {\n" + 
			"	height: 100%;\n" + 
			"	margin: 0;\n" + 
			"	padding: 0;\n" + 
			"	font-family: sans-serif;\n" + 
			"	font-size: 1em;\n" + 
			"}\n" + 
			"body {\n" + 
			"	background-color: #f3f3f3;\n" + 
			"	background-image: url(images/page-base.png?1);\n" + 
			"}\n" + 
			"/* Content */\n" + 
			"#content {\n" + 
			"	margin-left: 10em;\n" + 
			"	padding: 1em;\n" + 
			"	background-image: url(images/border.png?1);\n" + 
			"	background-position: top left;\n" + 
			"	background-repeat: repeat-y;\n" + 
			"	background-color: white;\n" + 
			"	color: black;\n" + 
			"}\n" + 
			"/* Head */\n" + 
			"#mw-page-base {\n" + 
			"	height: 5em;\n" + 
			"	background-color: white;\n" + 
			"	background-image: url(images/page-fade.png?1);\n" + 
			"	background-position: bottom left;\n" + 
			"	background-repeat: repeat-x;\n" + 
			"}\n" + 
			"#mw-head-base {\n" + 
			"	margin-top: -5em;\n" + 
			"	margin-left: 10em;\n" + 
			"	height: 5em;\n" + 
			"	background-image: url(images/border.png?1);\n" + 
			"	background-position: bottom left;\n" + 
			"	background-repeat: repeat-x;\n" + 
			"}\n" + 
			"div#mw-head {\n" + 
			"	position: absolute;\n" + 
			"	top: 0;\n" + 
			"	right: 0;\n" + 
			"	width: 100%;\n" + 
			"}\n" + 
			"div#mw-head h5 {\n" + 
			"	margin: 0;\n" + 
			"	padding: 0;\n" + 
			"}\n" + 
			"	/* Hide empty portlets */\n" + 
			"	div.emptyPortlet {\n" + 
			"		display: none;\n" + 
			"	}\n" + 
			"	/* Personal */\n" + 
			"	#p-personal {\n" + 
			"		position: absolute;\n" + 
			"		top: 0;\n" + 
			"		padding-left: 10em;\n" + 
			"		right: 0.75em;\n" + 
			"	}\n" + 
			"	#p-personal h5 {\n" + 
			"		display: none;\n" + 
			"	}\n" + 
			"	#p-personal ul {\n" + 
			"		list-style: none;\n" + 
			"		margin: 0;\n" + 
			"		padding: 0;\n" + 
			"	}\n" + 
			"	/* @noflip */\n" + 
			"	#p-personal li {\n" + 
			"		line-height: 1.125em;\n" + 
			"		float: left;\n" + 
			"	}\n" + 
			"	/* This one flips! */\n" + 
			"	#p-personal li {\n" + 
			"		margin-left: 0.75em;\n" + 
			"		margin-top: 0.5em;\n" + 
			"		font-size: 0.75em;\n" + 
			"		white-space: nowrap;\n" + 
			"	}\n" + 
			"	/* Navigation Containers */\n" + 
			"	#left-navigation {\n" + 
			"		position: absolute;\n" + 
			"		left: 10em;\n" + 
			"		top: 2.5em;\n" + 
			"	}\n" + 
			"	#right-navigation {\n" + 
			"		float: right;\n" + 
			"		margin-top: 2.5em;\n" + 
			"	}\n" + 
			"	/* Navigation Labels */\n" + 
			"	div.vectorTabs h5,\n" + 
			"	div.vectorMenu h5 span {\n" + 
			"		display: none;\n" + 
			"	}\n" + 
			"	/* Namespaces and Views */\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorTabs {\n" + 
			"		float: left;\n" + 
			"		height: 2.5em;\n" + 
			"	}\n" + 
			"	div.vectorTabs {\n" + 
			"		background-image: url(images/tab-break.png?1);\n" + 
			"		background-position: bottom left;\n" + 
			"		background-repeat: no-repeat;\n" + 
			"		padding-left: 1px;\n" + 
			"	}\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorTabs ul {\n" + 
			"		float: left;\n" + 
			"	}\n" + 
			"	div.vectorTabs ul {\n" + 
			"		height: 100%;\n" + 
			"		list-style: none;\n" + 
			"		margin: 0;\n" + 
			"		padding: 0;\n" + 
			"	}\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorTabs ul li {\n" + 
			"		float: left;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	div.vectorTabs ul li {\n" + 
			"		line-height: 1.125em;\n" + 
			"		display: inline-block;\n" + 
			"		height: 100%;\n" + 
			"		margin: 0;\n" + 
			"		padding: 0;\n" + 
			"		background-color: #f3f3f3;\n" + 
			"		background-image: url(images/tab-normal-fade.png?1);\n" + 
			"		background-position: bottom left;\n" + 
			"		background-repeat: repeat-x;\n" + 
			"		white-space:nowrap;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	div.vectorTabs ul > li {\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	div.vectorTabs li.selected {\n" + 
			"		background-image: url(images/tab-current-fade.png?1);\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	div.vectorTabs li a {\n" + 
			"		display: inline-block;\n" + 
			"		height: 2.5em;\n" + 
			"		padding-left: 0.4em;\n" + 
			"		padding-right: 0.4em;\n" + 
			"		background-image: url(images/tab-break.png?1);\n" + 
			"		background-position: bottom right;\n" + 
			"		background-repeat: no-repeat;\n" + 
			"	}\n" + 
			"	div.vectorTabs li a,\n" + 
			"	div.vectorTabs li a span {\n" + 
			"		color: #0645ad;\n" + 
			"		cursor: pointer;\n" + 
			"	}\n" + 
			"	div.vectorTabs li a span {\n" + 
			"		font-size: 0.8em;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	div.vectorTabs li > a {\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	div.vectorTabs a span {\n" + 
			"		display: inline-block;\n" + 
			"		padding-top: 1.25em;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorTabs a > span {\n" + 
			"		float: left;\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	div.vectorTabs li.selected a,\n" + 
			"	div.vectorTabs li.selected a span,\n" + 
			"	div.vectorTabs li.selected a:visited\n" + 
			"	div.vectorTabs li.selected a:visited span {\n" + 
			"		color: #333333;\n" + 
			"		text-decoration: none;\n" + 
			"	}\n" + 
			"	div.vectorTabs li.new a,\n" + 
			"	div.vectorTabs li.new a span,\n" + 
			"	div.vectorTabs li.new a:visited,\n" + 
			"	div.vectorTabs li.new a:visited span {\n" + 
			"		color: #a55858;\n" + 
			"	}\n" + 
			"	/* Variants and Actions */\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorMenu {\n" + 
			"		direction: ltr;\n" + 
			"		float: left;\n" + 
			"		background-image: url(images/arrow-down-icon.png?1);\n" + 
			"		background-position: 100% 60%;\n" + 
			"		background-repeat: no-repeat;\n" + 
			"		cursor: pointer;\n" + 
			"	}\n" + 
			"	/* @noflip */\n" + 
			"	body.rtl div.vectorMenu {\n" + 
			"		direction: rtl;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	/* @noflip */\n" + 
			"	div#mw-head div.vectorMenu h5 {\n" + 
			"		float: left;\n" + 
			"		background-image: url(images/tab-break.png?1);\n" + 
			"		background-repeat: no-repeat;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	div#mw-head div.vectorMenu > h5 {\n" + 
			"		background-image: none;\n" + 
			"	}\n" + 
			"	div#mw-head div.vectorMenu h5 {\n" + 
			"		background-position: bottom left;\n" + 
			"		margin-left: -1px;\n" + 
			"	}\n" + 
			"	div#mw-head div.vectorMenu h4 {\n" + 
			"		display: inline-block;\n" + 
			"		float: left;\n" + 
			"		font-size: 0.8em;\n" + 
			"		padding-left: 0.5em;\n" + 
			"		padding-top: 1.375em;\n" + 
			"		font-weight: normal;\n" + 
			"		border: none;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	/* @noflip */\n" + 
			"	div.vectorMenu h5 a {\n" + 
			"		display: inline-block;\n" + 
			"		width: 24px;\n" + 
			"		height: 2.5em;\n" + 
			"		text-decoration: none;\n" + 
			"		background-image: url(images/tab-break.png?1);\n" + 
			"		background-repeat: no-repeat;\n" + 
			"	}\n" + 
			"	div.vectorMenu h5 a{\n" + 
			"		background-position: bottom right;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	div.vectorMenu h5 > a {\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	div.vectorMenu div.menu {\n" + 
			"		position: relative;\n" + 
			"		display: none;\n" + 
			"		clear: both;\n" + 
			"		text-align: left;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	/* @noflip */\n" + 
			"	body.rtl div.vectorMenu div.menu {\n" + 
			"		margin-left: 24px;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	/* @noflip */\n" + 
			"	body.rtl div.vectorMenu > div.menu {\n" + 
			"		margin-left: auto;\n" + 
			"	}\n" + 
			"	/* Fixes old versions of FireFox */\n" + 
			"	/* @noflip */\n" + 
			"	body.rtl div.vectorMenu > div.menu,\n" + 
			"	x:-moz-any-link {\n" + 
			"		margin-left: 23px;\n" + 
			"	}\n" + 
			"	div.vectorMenu:hover div.menu {\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	div.vectorMenu ul {\n" + 
			"		position: absolute;\n" + 
			"		background-color: white;\n" + 
			"		border: solid 1px silver;\n" + 
			"		border-top-width: 0;\n" + 
			"		list-style: none;\n" + 
			"		list-style-image: none;\n" + 
			"		list-style-type: none;\n" + 
			"		padding: 0;\n" + 
			"		margin: 0;\n" + 
			"		margin-left: -1px;\n" + 
			"		text-align: left;\n" + 
			"	}\n" + 
			"	/* Fixes old versions of FireFox */\n" + 
			"	div.vectorMenu ul,\n" + 
			"	x:-moz-any-link {\n" + 
			"		min-width: 5em;\n" + 
			"	}\n" + 
			"	/* Returns things back to normal in modern versions of FireFox */\n" + 
			"	div.vectorMenu ul,\n" + 
			"	x:-moz-any-link,\n" + 
			"	x:default {\n" + 
			"		min-width: 0;\n" + 
			"	}\n" + 
			"	div.vectorMenu li {\n" + 
			"		padding: 0;\n" + 
			"		margin: 0;\n" + 
			"		text-align: left;\n" + 
			"		line-height: 1em;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	div.vectorMenu li a {\n" + 
			"		display: inline-block;\n" + 
			"		padding: 0.5em;\n" + 
			"		white-space: nowrap;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	div.vectorMenu li > a {\n" + 
			"		display: block;\n" + 
			"	}\n" + 
			"	div.vectorMenu li a {\n" + 
			"		color: #0645ad;\n" + 
			"		cursor: pointer;\n" + 
			"		font-size: 0.8em;\n" + 
			"	}\n" + 
			"	div.vectorMenu li.selected a,\n" + 
			"	div.vectorMenu li.selected a:visited {\n" + 
			"		color: #333333;\n" + 
			"		text-decoration: none;\n" + 
			"	}\n" + 
			"	/* Search */\n" + 
			"	#p-search h5 {\n" + 
			"		display: none;\n" + 
			"	}\n" + 
			"	/* @noflip */\n" + 
			"	#p-search {\n" + 
			"		float: left;\n" + 
			"	}\n" + 
			"	#p-search {\n" + 
			"		margin-right: 0.5em;\n" + 
			"		margin-left: 0.5em;\n" + 
			"	}\n" + 
			"	#p-search form,\n" + 
			"	#p-search input {\n" + 
			"		margin: 0;\n" + 
			"		margin-top: 0.4em;\n" + 
			"	}\n" + 
			"	#simpleSearch {\n" + 
			"		margin-top: 0.65em;\n" + 
			"		position: relative;\n" + 
			"		min-height: 1px; /* Gotta trigger hasLayout for IE7 */\n" + 
			"		border: solid 1px #AAAAAA;\n" + 
			"		background-color: white;\n" + 
			"		background-image: url(images/search-fade.png?1);\n" + 
			"		background-position: top left;\n" + 
			"		background-repeat: repeat-x;\n" + 
			"	}\n" + 
			"	#simpleSearch label {\n" + 
			"		font-size: 13px;\n" + 
			"		top: 0.25em;\n" + 
			"	}\n" + 
			"	div#simpleSearch .placeholder {\n" + 
			"		color: #999999;\n" + 
			"	}\n" + 
			"	div#simpleSearch input::-webkit-input-placeholder { \n" + 
			"		color: #999999;\n" + 
			"	}\n" + 
			"	div#simpleSearch input#searchInput {\n" + 
			"		margin: 0;\n" + 
			"		border-width: 0;\n" + 
			"		padding: 3px;\n" + 
			"		vertical-align: top;\n" + 
			"		font-size: 13px;\n" + 
			"		width: 14em;\n" + 
			"		background-color: transparent;\n" + 
			"	}\n" + 
			"	/* OVERRIDDEN BY COMPLIANT BROWSERS */\n" + 
			"	#simpleSearch button#searchButton {\n" + 
			"		padding: 0;\n" + 
			"		margin: 0 5px;\n" + 
			"		border: none;\n" + 
			"		cursor: pointer;\n" + 
			"		background-color: transparent;\n" + 
			"		font-size: x-small;\n" + 
			"	}\n" + 
			"	div#simpleSearch button#searchButton img {\n" + 
			"		border: none;\n" + 
			"		margin: 0;\n" + 
			"		padding: 0;\n" + 
			"		vertical-align: middle;\n" + 
			"	}\n" + 
			"/* Panel */\n" + 
			"div#mw-panel {\n" + 
			"	position: absolute;\n" + 
			"	top: 160px;\n" + 
			"	padding-top: 1em;\n" + 
			"	width: 10em;\n" + 
			"	left: 0;\n" + 
			"}\n" + 
			"	div#mw-panel div.portal {\n" + 
			"		padding-bottom: 1.5em;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal h5 {\n" + 
			"		font-weight: normal;\n" + 
			"		color: #444444;\n" + 
			"		padding: 0.25em;\n" + 
			"		padding-top: 0;\n" + 
			"		padding-left: 1.75em;\n" + 
			"		cursor: default;\n" + 
			"		border: none;\n" + 
			"		font-size: 0.75em;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal div.body {\n" + 
			"		margin: 0;\n" + 
			"		padding-top: 0.5em;\n" + 
			"		margin-left: 1.25em;\n" + 
			"		background-image: url(images/portal-break.png?1);\n" + 
			"		background-repeat: no-repeat;\n" + 
			"		background-position: top left;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal div.body ul {\n" + 
			"		list-style: none;\n" + 
			"		list-style-image: none;\n" + 
			"		list-style-type: none;\n" + 
			"		padding: 0;\n" + 
			"		margin: 0;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal div.body ul li {\n" + 
			"		line-height: 1.125em;\n" + 
			"		padding: 0;\n" + 
			"		padding-bottom: 0.5em;\n" + 
			"		margin: 0;\n" + 
			"		overflow: hidden;\n" + 
			"		font-size: 0.75em;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal div.body ul li a {\n" + 
			"		color: #0645ad;\n" + 
			"	}\n" + 
			"	div#mw-panel div.portal div.body ul li a:visited {\n" + 
			"		color: #0b0080;\n" + 
			"	}\n" + 
			"/* Footer */\n" + 
			"#footer {\n" + 
			"	margin-left: 10em;\n" + 
			"	margin-top: 0;\n" + 
			"	padding: 0.75em;\n" + 
			"	background-image: url(images/border.png?1);\n" + 
			"	background-position: top left;\n" + 
			"	background-repeat: repeat-x;\n" + 
			"}\n" + 
			"#footer ul {\n" + 
			"	list-style: none;\n" + 
			"	list-style-image: none;\n" + 
			"	list-style-type: none;\n" + 
			"	margin: 0;\n" + 
			"	padding: 0;\n" + 
			"}\n" + 
			"#footer ul li {\n" + 
			"	margin: 0;\n" + 
			"	padding: 0;\n" + 
			"	padding-top: 0.5em;\n" + 
			"	padding-bottom: 0.5em;\n" + 
			"	color: #333333;\n" + 
			"	font-size: 0.7em;\n" + 
			"}\n" + 
			"#footer #footer-icons {\n" + 
			"	float: right;\n" + 
			"}\n" + 
			"/* @noflip */\n" + 
			"body.ltr #footer #footer-places {\n" + 
			"	float: left;\n" + 
			"}\n" + 
			"#footer #footer-info li {\n" + 
			"	line-height: 1.4em;\n" + 
			"}\n" + 
			"#footer #footer-icons li {\n" + 
			"	float: left;\n" + 
			"	margin-left: 0.5em;\n" + 
			"	line-height: 2em;\n" + 
			"}\n" + 
			"#footer #footer-places li {\n" + 
			"	float: left;\n" + 
			"	margin-right: 1em;\n" + 
			"	line-height: 2em;\n" + 
			"}\n" + 
			"/* Logo */\n" + 
			"#p-logo {\n" + 
			"	position: absolute;\n" + 
			"	top: -160px;\n" + 
			"	left: 0;\n" + 
			"	width: 10em;\n" + 
			"	height: 160px;\n" + 
			"}\n" + 
			"#p-logo a {\n" + 
			"	display: block;\n" + 
			"	width: 10em;\n" + 
			"	height: 160px;\n" + 
			"	background-repeat: no-repeat;\n" + 
			"	background-position: center center;\n" + 
			"	text-decoration: none;\n" + 
			"}\n" + 
			"\n" + 
			"/*\n" + 
			" * \n" + 
			" * The following code is highly modified from monobook. It would be nice if the\n" + 
			" * preftoc id was more human readable like preferences-toc for instance,\n" + 
			" * howerver this would require backporting the other skins.\n" + 
			" */\n" + 
			"\n" + 
			"/* Preferences */\n" + 
			"#preftoc {\n" + 
			"	/* Tabs */\n" + 
			"	width: 100%;\n" + 
			"	float: left;\n" + 
			"	clear: both;\n" + 
			"	margin: 0 !important;\n" + 
			"	padding: 0 !important;\n" + 
			"	background-image: url(images/preferences-break.png?1);\n" + 
			"	background-position: bottom left;\n" + 
			"	background-repeat: no-repeat;\n" + 
			"}\n" + 
			"	#preftoc li {\n" + 
			"		/* Tab */\n" + 
			"		float: left;\n" + 
			"		margin: 0;\n" + 
			"		padding: 0;\n" + 
			"		padding-right: 1px;\n" + 
			"		height: 2.25em;\n" + 
			"		white-space: nowrap;\n" + 
			"		list-style-type: none;\n" + 
			"		list-style-image: none;\n" + 
			"		background-image: url(images/preferences-break.png?1);\n" + 
			"		background-position: bottom right;\n" + 
			"		background-repeat: no-repeat;\n" + 
			"	}\n" + 
			"	/* IGNORED BY IE6 */\n" + 
			"	#preftoc li:first-child {\n" + 
			"		margin-left: 1px;\n" + 
			"	}\n" + 
			"	#preftoc a,\n" + 
			"	#preftoc a:active {\n" + 
			"		display: inline-block;\n" + 
			"		position: relative;\n" + 
			"		color: #0645ad;\n" + 
			"		padding: 0.5em;\n" + 
			"		text-decoration: none;\n" + 
			"		background-image: none;\n" + 
			"		font-size: 0.9em;\n" + 
			"	}\n" + 
			"	#preftoc a:hover {\n" + 
			"		text-decoration: underline;\n" + 
			"	}\n" + 
			"	#preftoc li.selected a {\n" + 
			"		background-image: url(images/preferences-fade.png?1);\n" + 
			"		background-position: bottom;\n" + 
			"		background-repeat: repeat-x;\n" + 
			"		color: #333333;\n" + 
			"		text-decoration: none;\n" + 
			"	}\n" + 
			"#preferences {\n" + 
			"	float: left;\n" + 
			"	width: 100%;\n" + 
			"	margin: 0;\n" + 
			"	margin-top: -2px;\n" + 
			"	clear: both;\n" + 
			"	border: solid 1px #cccccc;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	background-image: url(images/preferences-base.png?1);\n" + 
			"}\n" + 
			"#preferences fieldset.prefsection {\n" + 
			"	border: none;\n" + 
			"	padding: 0;\n" + 
			"	margin: 1em;\n" + 
			"}\n" + 
			"#preferences fieldset.prefsection fieldset {\n" + 
			"	border: none;\n" + 
			"	border-top: solid 1px #cccccc;\n" + 
			"}\n" + 
			"#preferences legend {\n" + 
			"	color: #666666;\n" + 
			"}\n" + 
			"#preferences fieldset.prefsection legend.mainLegend {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"#preferences td {\n" + 
			"	padding-left: 0.5em;\n" + 
			"	padding-right: 0.5em;\n" + 
			"}\n" + 
			"#preferences td.htmlform-tip {\n" + 
			"	font-size: x-small;\n" + 
			"	padding: .2em 2em;\n" + 
			"	color: #666666;\n" + 
			"}\n" + 
			"#preferences div.mw-prefs-buttons {\n" + 
			"	padding: 1em;\n" + 
			"}\n" + 
			"#preferences div.mw-prefs-buttons input {\n" + 
			"	margin-right: 0.25em;\n" + 
			"}\n" + 
			"\n" + 
			"/* \n" + 
			" * Styles for the user login and create account forms\n" + 
			" */\n" + 
			"#userlogin, #userloginForm {\n" + 
			"	border: solid 1px #cccccc;\n" + 
			"	padding: 1.2em;\n" + 
			"	margin: .5em;\n" + 
			"	float: left;\n" + 
			"}\n" + 
			"\n" + 
			"#userlogin {\n" + 
			"	min-width: 20em;\n" + 
			"	max-width: 90%;\n" + 
			"	width: 40em;\n" + 
			"}\n" + 
			"\n" + 
			"/*\n" + 
			" * \n" + 
			" * The following code is slightly modified from monobook\n" + 
			" * \n" + 
			" */\n" + 
			"#content {\n" + 
			"	line-height: 1.5em;\n" + 
			"}\n" + 
			"#bodyContent {\n" + 
			"	font-size: 0.8em;\n" + 
			"}\n" + 
			"/* Links */\n" + 
			"a {\n" + 
			"	text-decoration: none;\n" + 
			"	color: #0645ad;\n" + 
			"	background: none;\n" + 
			"}\n" + 
			"a:visited {\n" + 
			"	color: #0b0080;\n" + 
			"}\n" + 
			"a:active {\n" + 
			"	color: #faa700;\n" + 
			"}\n" + 
			"a:hover {\n" + 
			"	text-decoration: underline;\n" + 
			"}\n" + 
			"a.stub {\n" + 
			"	color: #772233;\n" + 
			"}\n" + 
			"a.new, #p-personal a.new {\n" + 
			"	color: #ba0000;\n" + 
			"}\n" + 
			"a.new:visited, #p-personal a.new:visited {\n" + 
			"	color: #a55858;\n" + 
			"}\n" + 
			"\n" + 
			"/* Inline Elements */\n" + 
			"img {\n" + 
			"	border: none;\n" + 
			"	vertical-align: middle;\n" + 
			"}\n" + 
			"hr {\n" + 
			"	height: 1px;\n" + 
			"	color: #aaa;\n" + 
			"	background-color: #aaa;\n" + 
			"	border: 0;\n" + 
			"	margin: .2em 0 .2em 0;\n" + 
			"}\n" + 
			"\n" + 
			"/* Structural Elements */\n" + 
			"h1,\n" + 
			"h2,\n" + 
			"h3,\n" + 
			"h4,\n" + 
			"h5,\n" + 
			"h6 {\n" + 
			"	color: black;\n" + 
			"	background: none;\n" + 
			"	font-weight: normal;\n" + 
			"	margin: 0;\n" + 
			"	padding-top: .5em;\n" + 
			"	padding-bottom: .17em;\n" + 
			"	border-bottom: 1px solid #aaa;\n" + 
			"	width: auto;\n" + 
			"}\n" + 
			"h1 { font-size: 188%; }\n" + 
			"h1 .editsection { font-size: 53%; }\n" + 
			"h2 { font-size: 150%; }\n" + 
			"h2 .editsection { font-size: 67%; }\n" + 
			"h3,\n" + 
			"h4,\n" + 
			"h5,\n" + 
			"h6 {\n" + 
			"	border-bottom: none;\n" + 
			"	font-weight: bold;\n" + 
			"}\n" + 
			"h3 { font-size: 132%; }\n" + 
			"h3 .editsection { font-size: 76%; font-weight: normal; }\n" + 
			"h4 { font-size: 116%; }\n" + 
			"h4 .editsection { font-size: 86%; font-weight: normal; }\n" + 
			"h5 { font-size: 100%; }\n" + 
			"h5 .editsection { font-weight: normal; }\n" + 
			"h6 { font-size: 80%;  }\n" + 
			"h6 .editsection { font-size: 125%; font-weight: normal; }\n" + 
			"p {\n" + 
			"	margin: .4em 0 .5em 0;\n" + 
			"	line-height: 1.5em;\n" + 
			"}\n" + 
			"	p img {\n" + 
			"		margin: 0;\n" + 
			"	}\n" + 
			"abbr,\n" + 
			"acronym,\n" + 
			".explain {\n" + 
			"	border-bottom: 1px dotted black;\n" + 
			"	color: black;\n" + 
			"	background: none;\n" + 
			"	cursor: help;\n" + 
			"}\n" + 
			"q {\n" + 
			"	font-family: Times, \"Times New Roman\", serif;\n" + 
			"	font-style: italic;\n" + 
			"}\n" + 
			"/* Disabled for now\n" + 
			"blockquote {\n" + 
			"	font-family: Times, \"Times New Roman\", serif;\n" + 
			"	font-style: italic;\n" + 
			"}*/\n" + 
			"pre, code, tt {\n" + 
			"	/*\n" + 
			"	 * It's important for this rule to first reference an actual font name, some browsers will render the monospace text\n" + 
			"	 * too small otherwise, namely Firefox, Chrome and Safari\n" + 
			"	 */\n" + 
			"	font-family: monospace, \"Courier New\";\n" + 
			"}\n" + 
			"code {\n" + 
			"	background-color: #f9f9f9;\n" + 
			"}\n" + 
			"pre {\n" + 
			"	padding: 1em;\n" + 
			"	border: 1px dashed #2f6fab;\n" + 
			"	color: black;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	line-height: 1.1em;\n" + 
			"}\n" + 
			"ul {\n" + 
			"	line-height: 1.5em;\n" + 
			"	list-style-type: square;\n" + 
			"	margin: .3em 0 0 1.5em;\n" + 
			"	padding: 0;\n" + 
			"	list-style-image: url(images/bullet-icon.png?1);\n" + 
			"}\n" + 
			"ol {\n" + 
			"	line-height: 1.5em;\n" + 
			"	margin: .3em 0 0 3.2em;\n" + 
			"	padding: 0;\n" + 
			"	list-style-image: none;\n" + 
			"}\n" + 
			"li {\n" + 
			"	margin-bottom: .1em;\n" + 
			"}\n" + 
			"dt {\n" + 
			"	font-weight: bold;\n" + 
			"	margin-bottom: .1em;\n" + 
			"}\n" + 
			"dl {\n" + 
			"	margin-top: .2em;\n" + 
			"	margin-bottom: .5em;\n" + 
			"}\n" + 
			"dd {\n" + 
			"	line-height: 1.5em;\n" + 
			"	margin-left: 2em;\n" + 
			"	margin-bottom: .1em;\n" + 
			"}\n" + 
			"/* Tables */\n" + 
			"table {\n" + 
			"	font-size: 100%;\n" + 
			"	color: black;\n" + 
			"	/* we don't want the bottom borders of <h2>s to be visible through\n" + 
			"	 * floated tables */\n" + 
			"	background-color: white;\n" + 
			"}\n" + 
			"fieldset table {\n" + 
			"	/* but keep table layouts in forms clean... */\n" + 
			"	background: none;\n" + 
			"}\n" + 
			"/* Forms */\n" + 
			"fieldset {\n" + 
			"	border: 1px solid #2f6fab;\n" + 
			"	margin: 1em 0 1em 0;\n" + 
			"	padding: 0 1em 1em;\n" + 
			"	line-height: 1.5em;\n" + 
			"}\n" + 
			"	fieldset.nested {\n" + 
			"		margin: 0 0 0.5em 0;\n" + 
			"		padding: 0 0.5em 0.5em;\n" + 
			"	}\n" + 
			"legend {\n" + 
			"	padding: .5em;\n" + 
			"	font-size: 95%;\n" + 
			"}\n" + 
			"form {\n" + 
			"	border: none;\n" + 
			"	margin: 0;\n" + 
			"}\n" + 
			"textarea {\n" + 
			"	width: 100%;\n" + 
			"	padding: .1em;\n" + 
			"}\n" + 
			"select {\n" + 
			"	vertical-align: top;\n" + 
			"}\n" + 
			"/* Table of Contents */\n" + 
			"#toc,\n" + 
			".toc,\n" + 
			".mw-warning {\n" + 
			"	border: 1px solid #aaa;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	padding: 5px;\n" + 
			"	font-size: 95%;\n" + 
			"}\n" + 
			"#toc h2,\n" + 
			".toc h2 {\n" + 
			"	display: inline;\n" + 
			"	border: none;\n" + 
			"	padding: 0;\n" + 
			"	font-size: 100%;\n" + 
			"	font-weight: bold;\n" + 
			"}\n" + 
			"#toc #toctitle,\n" + 
			".toc #toctitle,\n" + 
			"#toc .toctitle,\n" + 
			".toc .toctitle {\n" + 
			"	text-align: center;\n" + 
			"}\n" + 
			"#toc ul,\n" + 
			".toc ul {\n" + 
			"	list-style-type: none;\n" + 
			"	list-style-image: none;\n" + 
			"	margin-left: 0;\n" + 
			"	padding-left: 0;\n" + 
			"	text-align: left;\n" + 
			"}\n" + 
			"#toc ul ul,\n" + 
			".toc ul ul {\n" + 
			"	margin: 0 0 0 2em;\n" + 
			"}\n" + 
			"#toc .toctoggle,\n" + 
			".toc .toctoggle {\n" + 
			"	font-size: 94%;\n" + 
			"}\n" + 
			"/* Images */\n" + 
			"div.floatright, table.floatright {\n" + 
			"	clear: right;\n" + 
			"	float: right;\n" + 
			"	position: relative;\n" + 
			"	margin: 0 0 .5em .5em;\n" + 
			"	border: 0;\n" + 
			"}\n" + 
			"div.floatright p { font-style: italic; }\n" + 
			"div.floatleft, table.floatleft {\n" + 
			"	float: left;\n" + 
			"	clear: left;\n" + 
			"	position: relative;\n" + 
			"	margin: 0 .5em .5em 0;\n" + 
			"	border: 0;\n" + 
			"}\n" + 
			"div.floatleft p { font-style: italic; }\n" + 
			"/* Thumbnails */\n" + 
			"div.thumb {\n" + 
			"	margin-bottom: .5em;\n" + 
			"	border-style: solid;\n" + 
			"	border-color: white;\n" + 
			"	width: auto;\n" + 
			"	background-color: transparent;\n" + 
			"}\n" + 
			"div.thumbinner {\n" + 
			"	border: 1px solid #ccc;\n" + 
			"	padding: 3px !important;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	font-size: 94%;\n" + 
			"	text-align: center;\n" + 
			"	overflow: hidden;\n" + 
			"}\n" + 
			"html .thumbimage {\n" + 
			"	border: 1px solid #ccc;\n" + 
			"}\n" + 
			"html .thumbcaption {\n" + 
			"	border: none;\n" + 
			"	text-align: left;\n" + 
			"	line-height: 1.4em;\n" + 
			"	padding: 3px !important;\n" + 
			"	font-size: 94%;\n" + 
			"}\n" + 
			"div.magnify {\n" + 
			"	float: right;\n" + 
			"	border: none !important;\n" + 
			"	background: none !important;\n" + 
			"}\n" + 
			"div.magnify a, div.magnify img {\n" + 
			"	display: block;\n" + 
			"	border: none !important;\n" + 
			"	background: none !important;\n" + 
			"}\n" + 
			"/* @noflip */\n" + 
			"div.tright {\n" + 
			"	clear: right;\n" + 
			"	float: right;\n" + 
			"	border-width: .5em 0 .8em 1.4em;\n" + 
			"}\n" + 
			"/* @noflip */\n" + 
			"div.tleft {\n" + 
			"	float: left;\n" + 
			"	clear: left;\n" + 
			"	margin-right: .5em;\n" + 
			"	border-width: .5em 1.4em .8em 0;\n" + 
			"}\n" + 
			"img.thumbborder {\n" + 
			"	border: 1px solid #dddddd;\n" + 
			"}\n" + 
			".hiddenStructure {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"/* Warning */\n" + 
			".mw-warning {\n" + 
			"	margin-left: 50px;\n" + 
			"	margin-right: 50px;\n" + 
			"	text-align: center;\n" + 
			"}\n" + 
			"/* User Message */\n" + 
			".usermessage {\n" + 
			"	background-color: #ffce7b;\n" + 
			"	border: 1px solid #ffa500;\n" + 
			"	color: black;\n" + 
			"	font-weight: bold;\n" + 
			"	margin: 2em 0 1em;\n" + 
			"	padding: .5em 1em;\n" + 
			"	vertical-align: middle;\n" + 
			"}\n" + 
			"/* Site Notice (includes notices from CentralNotice extension) */\n" + 
			"#siteNotice {\n" + 
			"	text-align: center;\n" + 
			"	font-size: 0.8em;\n" + 
			"	margin: 0;\n" + 
			"}\n" + 
			"#localNotice {\n" + 
			"	margin-bottom: 0.9em;\n" + 
			"}\n" + 
			"/* Categories */\n" + 
			".catlinks {\n" + 
			"	border: 1px solid #aaa;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	padding: 5px;\n" + 
			"	margin-top: 1em;\n" + 
			"	clear: both;\n" + 
			"}\n" + 
			"/* Sub-navigation */\n" + 
			"#siteSub {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"#jump-to-nav {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"#contentSub, #contentSub2 {\n" + 
			"	font-size: 84%;\n" + 
			"	line-height: 1.2em;\n" + 
			"	margin: 0 0 1.4em 1em;\n" + 
			"	color: #7d7d7d;\n" + 
			"	width: auto;\n" + 
			"}\n" + 
			"span.subpages {\n" + 
			"	display: block;\n" + 
			"}\n" + 
			"/* Emulate Center */\n" + 
			".center {\n" + 
			"	width: 100%;\n" + 
			"	text-align: center;\n" + 
			"}\n" + 
			"*.center * {\n" + 
			"	margin-left: auto;\n" + 
			"	margin-right: auto;\n" + 
			"}\n" + 
			"/* Small for tables and similar */\n" + 
			".small, .small * {\n" + 
			"	font-size: 94%;\n" + 
			"}\n" + 
			"table.small {\n" + 
			"	font-size: 100%;\n" + 
			"}\n" + 
			"/* Edge Cases for Content */\n" + 
			"h1, h2 {\n" + 
			"	margin-bottom: .6em;\n" + 
			"}\n" + 
			"h3, h4, h5 {\n" + 
			"	margin-bottom: .3em;\n" + 
			"}\n" + 
			"#firstHeading {\n" + 
			"	padding-top: 0;\n" + 
			"	margin-top: 0;\n" + 
			"	padding-top: 0;\n" + 
			"	margin-bottom: 0.1em;\n" + 
			"	line-height: 1.2em;\n" + 
			"	font-size: 1.6em;\n" + 
			"	padding-bottom: 0;\n" + 
			"}\n" + 
			"#content a.external,\n" + 
			"#content a[href ^=\"gopher://\"] {\n" + 
			"	background: url(images/external-link-ltr-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a[href ^=\"https://\"],\n" + 
			".link-https {\n" + 
			"	background: url(images/lock-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a[href ^=\"mailto:\"],\n" + 
			".link-mailto {\n" + 
			"	background: url(images/mail-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a[href ^=\"news://\"] {\n" + 
			"	background: url(images/news-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a[href ^=\"ftp://\"],\n" + 
			".link-ftp {\n" + 
			"	background: url(images/file-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a[href ^=\"irc://\"],\n" + 
			"#content a.extiw[href ^=\"irc://\"],\n" + 
			".link-irc {\n" + 
			"	background: url(images/talk-icon.png?2) center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a.external[href $=\".ogg\"], #content a.external[href $=\".OGG\"],\n" + 
			"#content a.external[href $=\".mid\"], #content a.external[href $=\".MID\"],\n" + 
			"#content a.external[href $=\".midi\"], #content a.external[href $=\".MIDI\"],\n" + 
			"#content a.external[href $=\".mp3\"], #content a.external[href $=\".MP3\"],\n" + 
			"#content a.external[href $=\".wav\"], #content a.external[href $=\".WAV\"],\n" + 
			"#content a.external[href $=\".wma\"], #content a.external[href $=\".WMA\"],\n" + 
			".link-audio {\n" + 
			"	background: url(\"images/audio-icon.png?2\") center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a.external[href $=\".ogm\"], #content a.external[href $=\".OGM\"],\n" + 
			"#content a.external[href $=\".avi\"], #content a.external[href $=\".AVI\"],\n" + 
			"#content a.external[href $=\".mpeg\"], #content a.external[href $=\".MPEG\"],\n" + 
			"#content a.external[href $=\".mpg\"], #content a.external[href $=\".MPG\"],\n" + 
			".link-video {\n" + 
			"	background: url(\"images/video-icon.png?2\") center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"#content a.external[href $=\".pdf\"], #content a.external[href $=\".PDF\"],\n" + 
			"#content a.external[href *=\".pdf#\"], #content a.external[href *=\".PDF#\"],\n" + 
			"#content a.external[href *=\".pdf?\"], #content a.external[href *=\".PDF?\"],\n" + 
			".link-document {\n" + 
			"	background: url(\"images/document-icon.png?2\") center right no-repeat;\n" + 
			"	padding: 0 13px 0 0;\n" + 
			"}\n" + 
			"/* Interwiki Styling  (Disabled) */\n" + 
			"#content a.extiw,\n" + 
			"#content a.extiw:active {\n" + 
			"	color: #36b;\n" + 
			"	background: none;\n" + 
			"	padding: 0;\n" + 
			"}\n" + 
			"#content a.external {\n" + 
			"	color: #36b;\n" + 
			"}\n" + 
			"#content .printfooter {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"/* Icon for Usernames */\n" + 
			"#pt-userpage,\n" + 
			"#pt-anonuserpage,\n" + 
			"#pt-login {\n" + 
			"	background: url(images/user-icon.png?1) left top no-repeat;\n" + 
			"	padding-left: 15px !important;\n" + 
			"	text-transform: none;\n" + 
			"}\n" + 
			"\n" + 
			".toccolours {\n" + 
			"	border: 1px solid #aaa;\n" + 
			"	background-color: #f9f9f9;\n" + 
			"	padding: 5px;\n" + 
			"	font-size: 95%;\n" + 
			"}\n" + 
			"#bodyContent {\n" + 
			"	position: relative;\n" + 
			"	width: 100%;\n" + 
			"}\n" + 
			"#mw-js-message {\n" + 
			"	font-size: 0.8em;\n" + 
			"}\n" + 
			"div#bodyContent {\n" + 
			"	line-height: 1.5em;\n" + 
			"}\n" + 
			"\n" + 
			"/* Watch/Unwatch Icon Styling */\n" + 
			"#ca-unwatch.icon,\n" + 
			"#ca-watch.icon {\n" + 
			"	margin-right:1px;\n" + 
			"}\n" + 
			"#ca-unwatch.icon a,\n" + 
			"#ca-watch.icon a {\n" + 
			"	margin: 0;\n" + 
			"	padding: 0;\n" + 
			"	outline: none;\n" + 
			"	display: block;\n" + 
			"	width: 26px;\n" + 
			"	height: 2.5em;\n" + 
			"}\n" + 
			"#ca-unwatch.icon a {\n" + 
			"	background-image: url(images/watch-icons.png?1);\n" + 
			"	background-position: -43px 60%;\n" + 
			"}\n" + 
			"#ca-watch.icon a {\n" + 
			"	background-image: url(images/watch-icons.png?1);\n" + 
			"	background-position: 5px 60%;\n" + 
			"}\n" + 
			"#ca-unwatch.icon a:hover {\n" + 
			"	background-image: url(images/watch-icons.png?1);\n" + 
			"	background-position: -67px 60%;\n" + 
			"}\n" + 
			"#ca-watch.icon a:hover {\n" + 
			"	background-image: url(images/watch-icons.png?1);\n" + 
			"	background-position: -19px 60%;\n" + 
			"}\n" + 
			"#ca-unwatch.icon a.loading,\n" + 
			"#ca-watch.icon a.loading {\n" + 
			"	background-image: url(images/watch-icon-loading.gif?1);\n" + 
			"	background-position: center 60%;\n" + 
			"}\n" + 
			"#ca-unwatch.icon a span,\n" + 
			"#ca-watch.icon a span {\n" + 
			"	display: none;\n" + 
			"}\n" + 
			"div.vectorTabs ul {\n" + 
			"	background-image:url(images/tab-break.png?1);\n" + 
			"	background-position:right bottom;\n" + 
			"	background-repeat:no-repeat;\n" + 
			"}\n" + 
			"</style>\n\n";
	/**
	 * Test CSS manipulations for the PDF file
	 */
	public final static String CSS_SCREEN_STYLE = "<style type=\"text/css\">\n"
			+ "\n"
			+ "#interwiki-completelist {\n"
			+ "    font-weight: bold;\n"
			+ "}\n"
			+ "\n"
			+ "body.page-Main_Page #ca-delete {\n"
			+ "    display: none !important;\n"
			+ "}\n"
			+ "\n"
			+ "#toolbar {\n"
			+ "    margin-bottom: 6px;\n"
			+ "}\n"
			+ "\n"
			+ "ol.references {\n"
			+ "    font-size: 100%;\n"
			+ "}\n"
			+ "\n"
			+ ".references-small { font-size: 90%;}\n"
			+ "\n"
			+ ".references-2column {\n"
			+ "    font-size: 90%;\n"
			+ "    -moz-column-count: 2;\n"
			+ "    -webkit-column-count: 2;\n"
			+ "    column-count: 2;\n"
			+ "}\n"
			+ "\n"
			+ ".same-bg { background: none; }\n"
			+ "\n"
			+ "ol.references > li:target {\n"
			+ "    background-color: #DEF;\n"
			+ "}\n"
			+ "\n"
			+ "sup.reference:target { \n"
			+ "    background-color: #DEF;\n"
			+ "}\n"
			+ "\n"
			+ "cite {\n"
			+ "    font-style: normal;\n"
			+ "    word-wrap: break-word;\n"
			+ "}\n"
			+ "\n"
			+ "cite:target { \n"
			+ "    background-color: #DEF;\n"
			+ "}\n"
			+ "\n"
			+ "@media print {\n"
			+ "    #content cite a.external.text:after {\n"
			+ "        display: none;\n"
			+ "    }\n"
			+ "}\n"
			+ "\n"
			+ "@media screen, handheld, projection {\n"
			+ "    cite *.printonly {\n"
			+ "        display: none;\n"
			+ "    }\n"
			+ "}\n"
			+ "\n"
			+ "table.wikitable,\n"
			+ "table.prettytable {\n"
			+ "    margin: 1em 1em 1em 0;\n"
			+ "    background: #f9f9f9;\n"
			+ "    border: 1px #aaa solid;\n"
			+ "    border-collapse: collapse;\n"
			+ "}\n"
			+ "\n"
			+ "table.wikitable th, table.wikitable td,\n"
			+ "table.prettytable th, table.prettytable td {\n"
			+ "    border: 1px #aaa solid;\n"
			+ "    padding: 0.2em;\n"
			+ "}\n"
			+ "\n"
			+ "table.wikitable th,\n"
			+ "table.prettytable th {\n"
			+ "    background: #f2f2f2;\n"
			+ "    text-align: center;\n"
			+ "}\n"
			+ "\n"
			+ "table.wikitable caption,\n"
			+ "table.prettytable caption {\n"
			+ "    margin-left: inherit;\n"
			+ "    margin-right: inherit;\n"
			+ "    font-weight: bold;\n"
			+ "}\n"
			+ "\n"
			+ "table.prettytable code,\n"
			+ "table.wikitable code {\n"
			+ "    background-color: transparent;\n"
			+ "}\n"
			+ "\n"
			+ "table.navbox {            \n"
			+ "  border:1px solid #aaa;\n"
			+ "  width:100%; \n"
			+ "  margin:auto;\n"
			+ "  clear:both;\n"
			+ "  font-size:88%;\n"
			+ "  text-align:center;\n"
			+ "  padding:1px;\n"
			+ "}\n"
			+ "table.navbox + table.navbox {\n"
			+ "  margin-top:-1px;    \n"
			+ "}\n"
			+ ".navbox-title, .navbox-abovebelow, table.navbox th {\n"
			+ "  text-align:center;   \n"
			+ "  padding-left:1em;\n"
			+ "  padding-right:1em;\n"
			+ "}\n"
			+ ".navbox-group {         \n"
			+ "  white-space:nowrap;\n"
			+ "  text-align:right;\n"
			+ "  font-weight:bold;\n"
			+ "  padding-left:1em;\n"
			+ "  padding-right:1em;\n"
			+ "}\n"
			+ ".navbox, .navbox-subgroup {\n"
			+ "  background:#fdfdfd;    \n"
			+ "}\n"
			+ ".navbox-list {\n"
			+ "  border-color:#fdfdfd; \n"
			+ "}\n"
			+ ".navbox-title, table.navbox th {\n"
			+ "  background:#ccccff;   \n"
			+ "}\n"
			+ ".navbox-abovebelow, .navbox-group, .navbox-subgroup .navbox-title {\n"
			+ "  background:#ddddff;    \n"
			+ "}\n"
			+ ".navbox-subgroup .navbox-group, .navbox-subgroup .navbox-abovebelow {\n"
			+ "  background:#e6e6ff;  \n"
			+ "}\n"
			+ ".navbox-even {\n"
			+ "  background:#f7f7f7;   \n"
			+ "}\n"
			+ ".navbox-odd {\n"
			+ "  background:transparent; \n"
			+ "}\n"
			+ " \n"
			+ "@media print {\n"
			+ "    .navbox {\n"
			+ "        display: none;\n"
			+ "    }\n"
			+ "}\n"
			+ "\n"
			+ ".infobox {\n"
			+ "    border: 1px solid #aaa;\n"
			+ "    background-color: #f9f9f9;\n"
			+ "    color: black;\n"
			+ "    margin: 0.5em 0 0.5em 1em;\n"
			+ "    padding: 0.2em;\n"
			+ "    float: right;\n"
			+ "    clear: right;\n"
			+ "}\n"
			+ ".infobox td,\n"
			+ ".infobox th {\n"
			+ "    vertical-align: top;\n"
			+ "}\n"
			+ ".infobox caption {\n"
			+ "    font-size: larger;\n"
			+ "    margin-left: inherit;\n"
			+ "}\n"
			+ ".infobox.bordered {\n"
			+ "    border-collapse: collapse;\n"
			+ "}\n"
			+ ".infobox.bordered td,\n"
			+ ".infobox.bordered th {\n"
			+ "    border: 1px solid #aaa;\n"
			+ "}\n"
			+ ".infobox.bordered .borderless td,\n"
			+ ".infobox.bordered .borderless th {\n"
			+ "    border: 0;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.sisterproject {\n"
			+ "    width: 20em;\n"
			+ "    font-size: 90%;\n"
			+ "}\n"
			+ "\n"
			+ "@media print {\n"
			+ "    .infobox.sisterproject {\n"
			+ "        display: none;\n"
			+ "    }\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.standard-talk {\n"
			+ "    border: 1px solid #c0c090;\n"
			+ "    background-color: #f8eaba;\n"
			+ "}\n"
			+ ".infobox.standard-talk.bordered td,\n"
			+ ".infobox.standard-talk.bordered th {\n"
			+ "    border: 1px solid #c0c090;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.bordered .mergedtoprow td,\n"
			+ ".infobox.bordered .mergedtoprow th {\n"
			+ "    border: 0;\n"
			+ "    border-top: 1px solid #aaa;\n"
			+ "    border-right: 1px solid #aaa;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.bordered .mergedrow td,\n"
			+ ".infobox.bordered .mergedrow th {\n"
			+ "    border: 0;\n"
			+ "    border-right: 1px solid #aaa;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.geography {\n"
			+ "    text-align: left;\n"
			+ "    border-collapse: collapse;\n"
			+ "    line-height: 1.2em; \n"
			+ "    font-size: 90%;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.geography  td,\n"
			+ ".infobox.geography  th {\n"
			+ "    border-top: solid 1px #aaa;\n"
			+ "    padding: 0.4em 0.6em 0.4em 0.6em;\n"
			+ "}\n"
			+ ".infobox.geography .mergedtoprow td,\n"
			+ ".infobox.geography .mergedtoprow th {\n"
			+ "    border-top: solid 1px #aaa;\n"
			+ "    padding: 0.4em 0.6em 0.2em 0.6em;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.geography .mergedrow td,\n"
			+ ".infobox.geography .mergedrow th {\n"
			+ "    border: 0;\n"
			+ "    padding: 0 0.6em 0.2em 0.6em;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.geography .mergedbottomrow td,\n"
			+ ".infobox.geography .mergedbottomrow th {\n"
			+ "    border-top: 0;\n"
			+ "    border-bottom: solid 1px #aaa;\n"
			+ "    padding: 0 0.6em 0.4em 0.6em;\n"
			+ "}\n"
			+ "\n"
			+ ".infobox.geography .maptable td,\n"
			+ ".infobox.geography .maptable th {\n"
			+ "    border: 0;\n"
			+ "    padding: 0;\n"
			+ "}\n"
			+ "\n"
			+ ".notice {\n"
			+ "    margin: 1em;\n"
			+ "    padding: 0.2em;\n"
			+ "}\n"
			+ "\n"
			+ "#disambig {\n"
			+ "    border-top: 1px solid #ccc; \n"
			+ "    border-bottom: 1px solid #ccc;\n"
			+ "}\n"
			+ "\n"
			+ ".spoiler {\n"
			+ "    border-top: 2px solid #ddd;\n"
			+ "    border-bottom: 2px solid #ddd;\n"
			+ "}\n"
			+ "\n"
			+ ".Talk-Notice  {\n"
			+ "    border: 1px solid #C0C090;\n"
			+ "    background-color: #F8EABA;\n"
			+ "    margin-bottom: 3px;\n"
			+ "    width: 85%;\n"
			+ "    border-spacing: 3px;\n"
			+ "    margin-left: auto;\n"
			+ "    margin-right: auto;\n"
			+ "}\n"
			+ "\n"
			+ ".Talk-Notice:after {\n"
			+ "  content: \"The CSS for this template should be changed. See [[Wikipedia:Template Standardisation]].\";\n"
			+ "}\n"
			+ "\n"
			+ ".Talk-Notice td {\n"
			+ "    background: inherit;\n"
			+ "}\n"
			+ "\n"
			+ "\n"
			+ "table.InChI,\n"
			+ "table.persondata {\n"
			+ "    border: 1px solid #aaa;\n"
			+ "    display: none;\n"
			+ "    speak: none;\n"
			+ "}\n"
			+ ".InChI-label, \n"
			+ ".persondata-label {\n"
			+ "    color: #aaa;\n"
			+ "}\n"
			+ "\n"
			+ ".redirect-in-category, .allpagesredirect {\n"
			+ "    font-style: italic;\n"
			+ "}\n"
			+ "\n"
			+ ".audiolink a {\n"
			+ "    background: url(\"http://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Loudspeaker.svg/11px-Loudspeaker.svg.png\") center left no-repeat !important;\n"
			+ "    padding-left: 16px !important;\n"
			+ "    padding-right: 0 !important;\n"
			+ "}\n"
			+ "\n"
			+ "div.listenlist {\n"
			+ "    background: url(\"http://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Gnome-speakernotes.png/30px-Gnome-speakernotes.png\");\n"
			+ "    padding-left: 40px;\n"
			+ "}\n"
			+ "\n"
			+ "div.videolist, div.multivideolist {\n"
			+ "    background: url(\"http://upload.wikimedia.org/wikipedia/en/thumb/2/20/Tango-video-x-generic.png/40px-Tango-video-x-generic.png\");\n"
			+ "    padding-left: 50px;\n"
			+ "}\n"
			+ "\n"
			+ "div.medialist {\n"
			+ "    min-height: 50px;\n"
			+ "    margin: 1em;\n"
			+ "    background-position: top left;\n"
			+ "    background-repeat: no-repeat;\n"
			+ "}\n"
			+ "\n"
			+ "div.medialist ul {\n"
			+ "    list-style-type: none; \n"
			+ "    list-style-image: none;\n"
			+ "    margin: 0;\n"
			+ "}\n"
			+ "\n"
			+ "div.medialist ul li {\n"
			+ "    padding-bottom: 0.5em;\n"
			+ "}\n"
			+ "\n"
			+ "div.medialist ul li li {\n"
			+ "    font-size: 91%;\n"
			+ "    padding-bottom: 0;\n"
			+ "}\n"
			+ "\n"
			+ "#bodyContent a[href$=\".pdf\"].external, \n"
			+ "#bodyContent a[href*=\".pdf?\"].external, \n"
			+ "#bodyContent a[href*=\".pdf#\"].external,\n"
			+ "#bodyContent a[href$=\".PDF\"].external, \n"
			+ "#bodyContent a[href*=\".PDF?\"].external, \n"
			+ "#bodyContent a[href*=\".PDF#\"].external,\n"
			+ "#mw_content a[href$=\".pdf\"].external, \n"
			+ "#mw_content a[href*=\".pdf?\"].external, \n"
			+ "#mw_content a[href*=\".pdf#\"].external,\n"
			+ "#mw_content a[href$=\".PDF\"].external, \n"
			+ "#mw_content a[href*=\".PDF?\"].external, \n"
			+ "#mw_content a[href*=\".PDF#\"].external {\n"
			+ "    background: url(http://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Icons-mini-file_acrobat.gif/15px-Icons-mini-file_acrobat.gif) center right no-repeat;\n"
			+ "    padding-right: 16px;\n"
			+ "}\n"
			+ "\n"
			+ "span.PDFlink a {\n"
			+ "    background: url(http://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Icons-mini-file_acrobat.gif/15px-Icons-mini-file_acrobat.gif) center right no-repeat !important;\n"
			+ "    padding-right: 17px !important;\n"
			+ "}\n"
			+ "\n"
			+ "span.geolink a {\n"
			+ "    background: url(http://upload.wikimedia.org/wikipedia/en/a/a7/Monobook-globe.png) center right no-repeat !important;\n"
			+ "    padding-right: 11px !important;\n"
			+ "}\n"
			+ "\n"
			+ "div.columns-2 div.column {\n"
			+ "    float: left;\n"
			+ "    width: 50%;\n"
			+ "    min-width: 300px;\n"
			+ "}\n"
			+ "\n"
			+ "div.columns-3 div.column {\n"
			+ "    float: left;\n"
			+ "    width: 33.3%;\n"
			+ "    min-width: 200px;\n"
			+ "}\n"
			+ "\n"
			+ "div.columns-4 div.column {\n"
			+ "    float: left;\n"
			+ "    width: 25%;\n"
			+ "    min-width: 150px;\n"
			+ "}\n"
			+ "\n"
			+ "div.columns-5 div.column {\n"
			+ "    float: left;\n"
			+ "    width: 20%;\n"
			+ "    min-width: 120px;\n"
			+ "}\n"
			+ "\n"
			+ ".plainlinksneverexpand {\n"
			+ "    background: none ! important;\n"
			+ "    padding: 0 ! important;\n"
			+ "}\n"
			+ "\n"
			+ ".plainlinksneverexpand .urlexpansion {\n"
			+ "    display: none ! important;\n"
			+ "}\n"
			+ "\n"
			+ ".plainlinksneverexpand a {\n"
			+ "    background: none !important;\n"
			+ "    padding: 0 !important;\n"
			+ "}\n"
			+ "\n"
			+ ".plainlinksneverexpand a.external.text:after {\n"
			+ "    display: none !important;\n"
			+ "}\n"
			+ ".plainlinksneverexpand a.external.autonumber:after {\n"
			+ "    display: none !important;\n"
			+ "}\n"
			+ "\n"
			+ "/* Messagebox templates */\n"
			+ ".messagebox {\n"
			+ "    border: 1px solid #aaa;\n"
			+ "    background-color: #f9f9f9;\n"
			+ "    width: 80%;\n"
			+ "    margin: 0 auto 1em auto;\n"
			+ "    padding: .2em;\n"
			+ "}\n"
			+ ".messagebox.merge {\n"
			+ "    border: 1px solid #c0b8cc;\n"
			+ "    background-color: #f0e5ff;\n"
			+ "    text-align: center;\n"
			+ "}\n"
			+ ".messagebox.cleanup {\n"
			+ "    border: 1px solid #9f9fff;\n"
			+ "    background-color: #efefff;\n"
			+ "    text-align: center;\n"
			+ "}\n"
			+ ".messagebox.standard-talk {\n"
			+ "    border: 1px solid #c0c090;\n"
			+ "    background-color: #f8eaba;\n"
			+ "}\n"
			+ ".messagebox.nested-talk {\n"
			+ "    border: 1px solid #c0c090;\n"
			+ "    background-color: #f8eaba;\n"
			+ "    width: 100%;\n"
			+ "    margin: 2px 0 0 0;\n"
			+ "    padding: 2px;\n"
			+ "}\n"
			+ ".messagebox.small {\n"
			+ "    width: 238px;\n"
			+ "    font-size: 85%;\n"
			+ "    float: right;\n"
			+ "    clear: both;\n"
			+ "    margin: 0 0 1em 1em;\n"
			+ "    line-height: 1.25em; \n"
			+ "}\n"
			+ ".messagebox.small-talk {\n"
			+ "    width: 238px;\n"
			+ "    font-size: 85%;\n"
			+ "    float: right;\n"
			+ "    clear: both;\n"
			+ "    margin: 0 0 1em 1em;\n"
			+ "    line-height: 1.25em; \n"
			+ "    background: #F8EABA;\n"
			+ "}\n"
			+ "\n"
			+ "table.ambox {           \n"
			+ "    margin: -1px 10%;   \n"
			+ "    border: 1px solid #aaa; \n"
			+ "    border-left: 10px solid #1e90ff;   \n"
			+ "    background: #fbfbfb; \n"
			+ "}\n"
			+ "th.ambox-text, td.ambox-text {    \n"
			+ "    border: none; \n"
			+ "    padding: 0.25em 0.5em;        \n"
			+ "    width: 100%;                 \n"
			+ "}\n"
			+ "td.ambox-image {               \n"
			+ "    border: none; \n"
			+ "    padding: 2px 0 2px 0.5em;     \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ "td.ambox-imageright {            \n"
			+ "    border: none; \n"
			+ "    padding: 2px 0.5em 2px 0;     \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ " \n"
			+ "table.ambox-notice {\n"
			+ "    border-left: 10px solid #1e90ff;   \n"
			+ "}\n"
			+ "table.ambox-speedy {\n"
			+ "    border-left: 10px solid #b22222; \n"
			+ "    background: #fee;               \n"
			+ "}\n"
			+ "table.ambox-delete,\n"
			+ "table.ambox-serious {\n"
			+ "    border-left: 10px solid #b22222;  \n"
			+ "}\n"
			+ "table.ambox-content {\n"
			+ "    border-left: 10px solid #f28500;   \n"
			+ "}\n"
			+ "table.ambox-style {\n"
			+ "    border-left: 10px solid #f4c430;   \n"
			+ "}\n"
			+ "table.ambox-move,\n"
			+ "table.ambox-merge {\n"
			+ "    border-left: 10px solid #9932cc;   \n"
			+ "}\n"
			+ "table.ambox-protection {\n"
			+ "    border-left: 10px solid #bba;     \n"
			+ "}\n"
			+ "table.ambox.ambox-mini {   \n"
			+ "    float: right;\n"
			+ "    clear: right;\n"
			+ "    margin: 0 0 0 1em;\n"
			+ "    width: 25%;\n"
			+ "}\n"
			+ "@media print {          \n"
			+ "    .ambox {\n"
			+ "        display: none;\n"
			+ "    }\n"
			+ "}\n"
			+ "\n"
			+ "table.imbox {\n"
			+ "    margin: 4px 10%; \n"
			+ "    border-collapse: collapse; \n"
			+ "    border: 3px solid #1e90ff;  \n"
			+ "    background: #fbfbfb;\n"
			+ "}\n"
			+ ".imbox-text .imbox {      \n"
			+ "    margin: 0 -0.5em;    \n"
			+ "}\n"
			+ ".mbox-inside .imbox {    \n"
			+ "    margin: 4px;\n"
			+ "}\n"
			+ "th.imbox-text, td.imbox-text {   \n"
			+ "    border: none; \n"
			+ "    padding: 0.25em 0.9em;       \n"
			+ "    width: 100%;\n"
			+ "}\n"
			+ "td.imbox-image {                \n"
			+ "    border: none; \n"
			+ "    padding: 2px 0 2px 0.9em;    \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ "td.imbox-imageright {         \n"
			+ "    border: none;\n"
			+ "    padding: 2px 0.9em 2px 0;     \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ " \n"
			+ "table.imbox-notice {\n"
			+ "    border: 3px solid #1e90ff;  \n"
			+ "}\n"
			+ "table.imbox-speedy {\n"
			+ "    border: 3px solid #b22222;  \n"
			+ "    background: #fee;            \n"
			+ "}\n"
			+ "table.imbox-delete {\n"
			+ "    border: 3px solid #b22222;    \n"
			+ "}\n"
			+ "table.imbox-content {\n"
			+ "    border: 3px solid #f28500;   \n"
			+ "}\n"
			+ "table.imbox-style {\n"
			+ "    border: 3px solid #f4c430;  \n"
			+ "}\n"
			+ "table.imbox-move {\n"
			+ "    border: 3px solid #9932cc;   \n"
			+ "}\n"
			+ "table.imbox-protection {\n"
			+ "    border: 3px solid #bba;      \n"
			+ "}\n"
			+ "table.imbox-license {\n"
			+ "    border: 3px solid #88a;     \n"
			+ "    background: #f7f8ff;        \n"
			+ "}\n"
			+ "table.imbox-featured {\n"
			+ "    border: 3px solid #cba135;   \n"
			+ "}\n"
			+ "\n"
			+ "table.cmbox {\n"
			+ "    margin: -1px 10%;\n"
			+ "    border: 1px solid #aaa; \n"
			+ "    background: #DFE8FF;           \n"
			+ "}\n"
			+ "th.cmbox-text, td.cmbox-text {   \n"
			+ "    border: none; \n"
			+ "    padding: 0.25em 0.5em;        \n"
			+ "    width: 100%;\n"
			+ "}\n"
			+ "td.cmbox-image {                  \n"
			+ "    border: none; \n"
			+ "    padding: 2px 0 2px 0.5em;     \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ "td.cmbox-imageright {             \n"
			+ "    border: none;\n"
			+ "    padding: 2px 0.8em 2px 0;     \n"
			+ "    text-align: center; \n"
			+ "}\n"
			+ " \n"
			+ "table.cmbox-notice {\n"
			+ "    background: #DFE8FF; \n"
			+ "}\n"
			+ "table.cmbox-speedy {\n"
			+ "    margin-top: 1px;\n"
			+ "    margin-bottom: 1px;\n"
			+ "    border: 4px solid #b22222;  \n"
			+ "    background: #FFDBDB;        \n"
			+ "}\n"
			+ "table.cmbox-delete {\n"
			+ "    background: #FFDBDB;  \n"
			+ "}\n"
			+ "table.cmbox-content {\n"
			+ "    background: #FFE7CE;    \n"
			+ "}\n"
			+ "table.cmbox-style {\n"
			+ "    background: #FFF9DB;  \n"
			+ "}\n"
			+ "table.cmbox-move {\n"
			+ "    background: #F1D0FF;   \n"
			+ "}\n"
			+ "table.cmbox-protection {\n"
			+ "    background: #EFEFE1;   \n"
			+ "}\n"
			+ "\n"
			+ "#file img {\n"
			+ "    background: url(\"http://upload.wikimedia.org/wikipedia/commons/5/5d/Checker-16x16.png\") repeat;\n"
			+ "}\n"
			+ "\n"
			+ ".IPA {\n"
			+ "    font-family: \"Charis SIL\", \"Doulos SIL\", Gentium, GentiumAlt, \"DejaVu Sans\", Code2000, \"TITUS Cyberbit Basic\", \"Arial Unicode MS\", \"Lucida Sans Unicode\", \"Chrysanthi Unicode\";\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ".Unicode {\n"
			+ "    font-family: Code2000, Code2001, \"Free Serif\", \"TITUS Cyberbit Basic\", \"Doulos SIL\", \"Chrysanthi Unicode\", \"Bitstream Cyberbit\", \"Bitstream CyberBase\", Thryomanes, Gentium, GentiumAlt, \"Lucida Grande\", \"Free Sans\", \"Arial Unicode MS\", \"Microsoft Sans Serif\", \"Lucida Sans Unicode\";\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ".latinx {\n"
			+ "    font-family: Code2000, Code2001, \"TITUS Cyberbit Basic\", \"Microsoft Sans Serif\";\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ".polytonic {\n"
			+ "    font-family: \"Athena Unicode\", Gentium, \"Palatino Linotype\", \"Arial Unicode MS\", \"Lucida Sans Unicode\", \"Lucida Grande\", Code2000; \n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ".mufi {\n"
			+ "    font-family: Alphabetum, Cardo, LeedsUni, Junicode, \"TITUS Cyberbit Basic\", ALPHA-Demo;\n"
			+ "}\n"
			+ "\n"
			+ "\n"
			+ ":lang(he) {\n"
			+ "    font-family: \"SBL Hebrew\", \"Ezra SIL SR\", \"Ezra SIL\", Cardo, \"Chrysanthi Unicode\", \"TITUS Cyberbit Basic\", \"Arial Unicode MS\", Narkisim, \"Times New Roman\";\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(fa) {\n"
			+ "    font-family: \"Nafees Nastaleeq\", \"Pak Nastaleeq\", PDMS_Jauhar;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(ps) {\n"
			+ "    font-family: \"Nafees Nastaleeq\", \"Pak Nastaleeq\", PDMS_Jauhar;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(ur) {\n"
			+ "    font-family: \"Nafees Nastaleeq\", \"Pak Nastaleeq\", PDMS_Jauhar;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(sux-Xsux) {\n"
			+ "    font-family: Akkadian;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(ja) {\n"
			+ "       font-family: Code2000, \"Arial Unicode MS\", \"Bitstream Cyberbit\", \"Bitstream CyberCJK\", IPAGothic, IPAPGothic, IPAUIGothic, \"Kochi Gothic\", IPAMincho, IPAPMincho;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(ko) {\n"
			+ "    font-family: \"Adobe Myungjo Std M\", AppleMyungjo, \"Baekmuk Batang\", \"Baekmuk Gulim\", Batang, Dotum, DotumChe, Gulim, GulimChe, HYGothic-Extra, HYMyeongJo-Extra, \"New Gulim\", UnBatang, UnDotum, UnYetgul, UWKMJF;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(zh-Hans) {\n"
			+ "    font-family: \"Adobe Song Std L\", \"AR PL ShanHeiSun Uni\", \"AR PL ShanHeiSun Uni MBE\", \"MS Hei\", \"MS Song\", SimHei;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(zh-Hant) {\n"
			+ "    font-family: \"Adobe Ming Std L\", \"AR PL New Sung\", \"AR PL ZenKai Uni\", \"AR PL ZenKai Uni MBE\", MingLiU, PMingLiU;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ ":lang(grc) {\n"
			+ "    font-family: \"Athena Unicode\", Gentium, \"Palatino Linotype\", \"Arial Unicode MS\", \"Lucida Sans Unicode\", \"Lucida Grande\", Code2000;\n"
			+ "    font-family /**/:inherit;\n"
			+ "}\n"
			+ "\n"
			+ "#wpSave {\n"
			+ "    font-weight: bold;\n"
			+ "}\n"
			+ "\n"
			+ ".hiddenStructure {\n"
			+ "    display: inline ! important;\n"
			+ "    color: #f00; \n"
			+ "    background-color: #0f0;\n"
			+ "}\n"
			+ "\n"
			+ ".check-icon a.new {\n"
			+ "    display: none; \n"
			+ "    speak:none;\n"
			+ "}\n"
			+ "\n"
			+ ".nounderlines a { \n"
			+ "    text-decoration: none;\n"
			+ "}\n"
			+ "\n"
			+ ".IPA a:link, .IPA a:visited {\n"
			+ "    text-decoration: none;\n"
			+ "}\n"
			+ "\n"
			+ "@media print {\n"
			+ "    #privacy, #about, #disclaimer {display:none;}\n"
			+ "}\n"
			+ "\n"
			+ "#EnWpMpBook { background-image: url(http://upload.wikimedia.org/wikipedia/en/7/7e/MP-open-book.png); }\n"
			+ "#EnWpMpSearch { background: url(http://upload.wikimedia.org/wikipedia/en/a/ae/MP-magnifying-glass.png) no-repeat top right; }\n"
			+ "#EnWpMpSearchInner { float: right; width: 20em; text-align: center; }\n"
			+ "#EnWpMpBook2 { background-image: url(http://upload.wikimedia.org/wikipedia/commons/8/8e/MP-open-book2.png); }\n" + "\n"
			+ "div.Boxmerge,\n" + "div.NavFrame {\n" + "    margin: 0;\n" + "    padding: 4px;\n" + "    border: 1px solid #aaa;\n"
			+ "    text-align: center;\n" + "    border-collapse: collapse;\n" + "    font-size: 95%;\n" + "}\n"
			+ "div.Boxmerge div.NavFrame {\n" + "    border-style: none;\n" + "    border-style: hidden;\n" + "}\n"
			+ "div.NavFrame + div.NavFrame {\n" + "    border-top-style: none;\n" + "    border-top-style: hidden;\n" + "}\n"
			+ "div.NavPic {\n" + "    background-color: #fff;\n" + "    margin: 0;\n" + "    padding: 2px;\n" + "    float: left;\n"
			+ "}\n" + "div.NavFrame div.NavHead {\n" + "    height: 1.6em;\n" + "    font-weight: bold;\n"
			+ "    background-color: #ccf;\n" + "    position:relative;\n" + "}\n" + "div.NavFrame p {\n" + "    font-size: 100%;\n"
			+ "}\n" + "div.NavFrame div.NavContent {\n" + "    font-size: 100%;\n" + "}\n" + "div.NavFrame div.NavContent p {\n"
			+ "    font-size: 100%;\n" + "}\n" + "div.NavEnd {\n" + "    margin: 0;\n" + "    padding: 0;\n" + "    line-height: 1px;\n"
			+ "    clear: both;\n" + "}\n" + "a.NavToggle {\n" + "    position: absolute;\n" + "    top: 0;\n" + "    right: 3px;\n"
			+ "    font-weight: normal;\n" + "    font-size: 90%;\n" + "}\n" + "\n" + ".mw-plusminus-pos {\n" + "    color: #006400;\n"
			+ "}\n" + "\n" + ".mw-plusminus-neg {\n" + "    color: #8B0000; \n" + "}\n" + "\n" + ".dablink {\n"
			+ "    font-style: italic;\n" + "    padding-left: 2em;\n" + "}\n" + "\n" + ".dablink i {\n" + "    font-style: normal;\n"
			+ "}\n" + "\n" + ".horizontal ul {\n" + "    padding: 0;\n" + "    margin: 0;\n" + "}\n" + "\n" + ".horizontal li { \n"
			+ "    padding: 0 0.6em 0 0.4em;\n" + "    display: inline;\n" + "    border-right: 1px solid;\n" + "}\n" + "\n"
			+ ".horizontal li:last-child {\n" + "    border-right: none;\n" + "    padding-right: 0;\n" + "}\n" + "\n"
			+ ".geo-default { display: inline; }\n" + ".geo-nondefault { display: none; }\n" + ".geo-dms { display: inline; }\n"
			+ ".geo-dec { display: inline; }\n" + ".geo-multi-punct { display: none; }\n" + "\n" + ".longitude, .latitude {\n"
			+ "    white-space: nowrap;\n" + "}\n" + "\n" + ".nonumtoc .tocnumber { display:none; }\n" + ".nonumtoc #toc ul,\n"
			+ ".nonumtoc .toc ul {\n" + "    line-height: 1.5em;\n" + "    list-style: none;\n" + "    margin: .3em 0 0;\n"
			+ "    padding: 0;\n" + "}\n" + ".nonumtoc #toc ul ul, \n" + ".nonumtoc .toc ul ul { \n" + "    margin: 0 0 0 2em; \n"
			+ "}\n" + "\n" + ".toclimit-2 .toclevel-2 {display:none;}\n" + ".toclimit-3 .toclevel-3 {display:none;}\n"
			+ ".toclimit-4 .toclevel-4 {display:none;}\n" + ".toclimit-5 .toclevel-5 {display:none;}\n"
			+ ".toclimit-6 .toclevel-6 {display:none;}\n" + ".toclimit-7 .toclevel-7 {display:none;}\n" + "\n"
			+ ".listify td {display:list-item;}\n" + ".listify tr {display:block;}\n" + ".listify table {display:block;}\n" + "\n" + "\n"
			+ "blockquote.templatequote { margin-top: 0; }\n" + "\n" + "blockquote.templatequote div.templatequotecite { \n"
			+ "    line-height: 1em;\n" + "    text-align: left;\n" + "    padding-left: 2em;\n" + "    margin-top: 0;\n" + "}\n" + "\n"
			+ "blockquote.templatequote div.templatequotecite cite {\n" + "    font-size: 85%;\n" + "}\n" + "\n" + "div.user-block {\n"
			+ "    padding: 5px;\n" + "    border: 1px solid #A9A9A9;\n" + "    background-color: #FFEFD5;\n" + "}\n" + "\n"
			+ ".nowraplinks a {\n" + "    white-space: nowrap;\n" + "}\n" + "\n" + ".template-documentation {\n" + "    clear: both;\n"
			+ "    margin: 1em 0 0 0;\n" + "    border: 1px solid #aaa; \n" + "    background-color: #ecfcf4; \n" + "    padding: 5px;\n"
			+ "}\n" + "\n" + ".thumbinner {\n" + "    min-width: 100px;\n" + "}\n" + "\n" + ".imagemap-inline div {\n"
			+ "    display: inline;\n" + "}\n" + "\n" + "#wpUploadDescription {\n" + "    height: 13em;\n" + "}\n" + "\n"
			+ "sup, sub {\n" + "    line-height: 1em;\n" + "}\n" + "</style>\n" + "";

	public final static String CSS_PRINTER_STYLE = "<style type=\"text/css\">\n" + "a.stub,\n"
			+ "a.new{ color:#ba0000; text-decoration:none; }\n" + "\n" + "#toc { \n" + "    /*border:1px solid #2f6fab;*/\n"
			+ "    border:1px solid #aaaaaa;\n" + "    background-color:#f9f9f9;\n" + "    padding:5px;\n" + "}\n" + ".tocindent {\n"
			+ "	margin-left: 2em;\n" + "}\n" + ".tocline {\n" + "	margin-bottom: 0px;\n" + "}\n" + "\n" + "/* images */\n"
			+ "div.floatright { \n" + "    float: right;\n" + "    clear: right;\n" + "    margin: 0;\n" + "    position:relative;\n"
			+ "    border: 0.5em solid White;\n" + "    border-width: 0.5em 0 0.8em 1.4em;\n" + "}\n"
			+ "div.floatright p { font-style: italic;} \n" + "div.floatleft { \n" + "    float: left; \n"
			+ "    margin: 0.3em 0.5em 0.5em 0;\n" + "    position:relative;\n" + "    border: 0.5em solid White;\n"
			+ "    border-width: 0.5em 1.4em 0.8em 0;\n" + "}\n" + "div.floatleft p { font-style: italic; } \n" + "/* thumbnails */\n"
			+ "div.thumb {\n" + "    margin-bottom: 0.5em;\n" + "    border-style: solid; border-color: White;\n" + "    width: auto;\n"
			+ "    overflow: hidden;\n" + "}\n" + "div.thumb div {\n" + "    border:1px solid #cccccc;\n"
			+ "    padding: 3px !important;\n" + "    background-color:#f9f9f9;\n" + "    font-size: 94%;\n"
			+ "    text-align: center;\n" + "}\n" + "div.thumb div a img {\n" + "    border:1px solid #cccccc;\n" + "}\n"
			+ "div.thumb div div.thumbcaption {\n" + "    border: none;\n" + "    padding: 0.3em 0 0.1em 0;\n" + "}\n"
			+ "div.magnify { display: none; }\n" + "div.tright {\n" + "    float: right;\n" + "    clear: right;\n"
			+ "    border-width: 0.5em 0 0.8em 1.4em;\n" + "}\n" + "div.tleft {\n" + "    float: left;\n" + "    margin-right:0.5em;\n"
			+ "    border-width: 0.5em 1.4em 0.8em 0;\n" + "}\n" + "img.thumbborder {\n" + "	border: 1px solid #dddddd;\n" + "}\n" + "\n"
			+ "/* table standards */\n" + "table.rimage {\n" + "    float:right; \n" + "    width:1pt; \n" + "    position:relative;\n"
			+ "    margin-left:1em; \n" + "    margin-bottom:1em;\n" + "    text-align:center;\n" + "}\n" + "\n" + "body {\n"
			+ "    background: White;\n" + "    /*font-size: 11pt !important;*/\n" + "    color: Black;\n" + "    margin: 0;\n"
			+ "    padding: 0;\n" + "}\n" + "\n" + ".noprint,\n" + "div#jump-to-nav,\n" + "div.top,\n" + "div#column-one,\n"
			+ "#colophon,\n" + ".editsection,\n" + ".toctoggle,\n" + ".tochidden,\n" + "div#f-poweredbyico,\n" + "div#f-copyrightico,\n"
			+ "li#viewcount,\n" + "li#about,\n" + "li#disclaimer,\n" + "li#privacy {\n"
			+ "    /* Hides all the elements irrelevant for printing */\n" + "    display: none;\n" + "}\n" + "\n" + "ul { \n"
			+ "    list-style-type: square;\n" + "}\n" + "\n" + "#content {\n" + "    background: none;\n"
			+ "    border: none ! important;\n" + "    padding: 0 ! important;\n" + "    margin: 0 ! important;\n" + "}\n"
			+ "#footer {\n" + "	background : white;\n" + "	color : black;\n" + "    border-top: 1px solid black;\n" + "}\n" + "\n"
			+ "h1, h2, h3, h4, h5, h6 {\n" + "	font-weight: bold;\n" + "}\n" + "\n" + "p, .documentDescription {\n"
			+ "    margin: 1em 0 ! important;\n" + "    line-height: 1.2em;\n" + "}\n" + "\n" + ".tocindent p {\n"
			+ "	margin: 0 0 0 0 ! important;\n" + "}\n" + "\n" + "pre {\n" + "    border: 1pt dashed black;\n"
			+ "    white-space: pre;\n" + "    font-size: 8pt;\n" + "    overflow: auto;\n" + "    padding: 1em 0;\n"
			+ "	background : white;\n" + "	color : black;\n" + "}\n" + "\n" + "table.listing,\n" + "table.listing td {\n"
			+ "    border: 1pt solid black;\n" + "    border-collapse: collapse;\n" + "}\n" + "\n" + "a {\n"
			+ "    color: Black !important;\n" + "    background: none !important;\n" + "    padding: 0 !important;\n" + "}\n" + "\n"
			+ "a:link, a:visited {\n" + "    color: #520;\n" + "    background: transparent;\n" + "    text-decoration: underline;\n"
			+ "}\n" + "\n" + "#content a.external.text:after, #content a.external.autonumber:after {\n"
			+ "    /* Expand URLs for printing */\n" + "    content: \" (\" attr(href) \") \";\n" + "}\n" + "\n" + "#globalWrapper {\n"
			+ "    width: 100% !important;\n" + "    min-width: 0 !important;\n" + "}\n" + "\n" + "#content {\n"
			+ "	background : white;\n" + "	color : black;\n" + "}\n" + "\n" + "#column-content {\n" + "    margin: 0 !important;\n"
			+ "}\n" + "\n" + "#column-content #content {\n" + "    padding: 1em;\n" + "    margin: 0 !important;\n" + "}\n"
			+ "/* MSIE/Win doesn\'t understand \'inherit\' */\n" + "a, a.external, a.new, a.stub {\n" + "	color: black ! important;\n"
			+ "	text-decoration: none ! important;\n" + "}\n" + "\n" + "/* Continue ... */\n" + "a, a.external, a.new, a.stub {\n"
			+ "	color: inherit ! important;\n" + "	text-decoration: inherit ! important;\n" + "}\n" + "\n" + "img { border: none; }\n"
			+ "img.tex { vertical-align: middle; }\n" + "span.texhtml { font-family: serif; }\n" + "\n" + "div.townBox {\n"
			+ "    position:relative;\n" + "    float:right;\n" + "    background:White;\n" + "    margin-left:1em;\n"
			+ "    border: 1px solid gray;\n" + "    padding:0.3em;\n" + "    width: 200px;\n" + "    overflow: hidden;\n"
			+ "    clear: right;\n" + "}\n" + "div.townBox dl {\n" + "    padding: 0;\n" + "    margin: 0 0 0.3em 0; \n"
			+ "    font-size: 96%;\n" + "}\n" + "div.townBox dl dt {\n" + "    background: none;\n" + "    margin: 0.4em 0 0 0;\n"
			+ "}\n" + "div.townBox dl dd {\n" + "    margin: 0.1em 0 0 1.1em;\n" + "    background-color: #f3f3f3;\n" + "}\n" + "\n"
			+ "#siteNotice { display: none; }\n" + "\n" + "table.gallery {\n" + "        border:  1px solid #cccccc;\n"
			+ "        margin:  2px;\n" + "        padding: 2px;\n" + "        background-color:#ffffff;\n" + "}\n" + "\n"
			+ "table.gallery tr { \n" + "        vertical-align:top;\n" + "}\n" + "\n" + "div.gallerybox {\n"
			+ "        border: 1px solid #cccccc;\n" + "        margin: 2px;\n" + "        background-color:#f9f9f9;\n"
			+ "        width:  150px;\n" + "}\n" + "\n" + "div.gallerybox div.thumb {\n" + "        text-align: center;\n"
			+ "        border: 1px solid #cccccc;\n" + "        margin: 2px;\n" + "}       \n" + "\n" + "div.gallerytext {\n"
			+ "        font-size: 94%;\n" + "        padding: 2px 4px;\n" + "}       \n" + "\n" + "/*\n" + "** Diff rendering\n" + "*/\n"
			+ "table.diff { background:white; }\n" + "td.diff-otitle { background:#ffffff; }\n"
			+ "td.diff-ntitle { background:#ffffff; }\n" + "td.diff-addedline {\n" + "    background:#ccffcc;\n"
			+ "    font-size: smaller;\n" + "    border: solid 2px black;\n" + "}\n" + "td.diff-deletedline {\n"
			+ "    background:#ffffaa;\n" + "    font-size: smaller;\n" + "    border: dotted 2px black;\n" + "}\n"
			+ "td.diff-context {\n" + "    background:#eeeeee;\n" + "    font-size: smaller;\n" + "}\n" + ".diffchange {\n"
			+ "    color: silver;\n" + "    font-weight: bold;\n" + "    text-decoration: underline;\n" + "}\n" + "</style>\n" + "";

	// public final static String CSS_STYLE = "<style type=\"text/css\">\n" +
	// "h1 { color: maroon; }\n" + "h2 { color: orange; }\n"
	// + "b  { color: green; }\n" + "@page { \n" + "margin: 0.25in; \n" +
	// "-fs-flow-top: header; \n" + "-fs-flow-bottom: footer; \n"
	// + "-fs-flow-left: left; \n" + "-fs-flow-right: right; \n" +
	// "padding: 1em; \n" + "} \n" + "</style>\n";
	/**
	 * With a <code>wikipedia.css</code> file you can set the CSS of the rendered
	 * HTML data:
	 */
	public final static String HTML_HEADER1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\" dir=\"ltr\">\n"
			+ "	<head>\n"
			+ "   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> \n"
			+ "		<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\n";

	public final static String HTML_HEADER2 = "	</head>\n" + "\n" + "<body>";

	public final static String HTML_FOOTER = "</body></html>\n";

}

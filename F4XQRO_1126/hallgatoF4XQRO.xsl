<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <title>Hallgatók adatai for-each, value-of</title>
            <style>
                table { border-collapse: collapse; width: 200px; }
                tr { background-color: white;}
                th, td { border: 1px solid black; padding: 8px; text-align: left; }
                th { background-color: green; }
            </style>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Vezetéknév</th>
                    <th>Keresztnév</th>
                    <th>Becenév</th>
                    <th>Kor</th>
                    <th>Ösztöndíj</th>
                </tr>
                <xsl:for-each select="class/student">
                    <tr>
                        <td><xsl:value-of select="@id"/></td>
                        <td><xsl:value-of select="vezeteknev"/></td>
                        <td><xsl:value-of select="keresztnev"/></td>
                        <td><xsl:value-of select="becenev"/></td>
                        <td><xsl:value-of select="kor"/></td>
                        <td><xsl:value-of select="osztondij"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </html>
    </xsl:template>
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
</xsl:stylesheet>

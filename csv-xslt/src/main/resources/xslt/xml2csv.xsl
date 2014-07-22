<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" indent="no" encoding="utf-8"/>
    <xsl:strip-space elements="*"/>
    <xsl:template match="/">
        date,description,amount,balance
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/statements/statement">
        <xsl:value-of select="date"/>,<xsl:value-of select="description"/>,<xsl:value-of select="amount"/>,<xsl:value-of
            select="balance"/>
    </xsl:template>
</xsl:stylesheet>
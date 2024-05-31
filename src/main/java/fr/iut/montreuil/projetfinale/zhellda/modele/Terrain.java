package fr.iut.montreuil.projetfinale.zhellda.modele;
public class Terrain {
    private int tab[][];

    public Terrain() {
        this.tab = new int[][] {
                {41,41,366,367,367,367,367,362,363,41,48,102,41,41,41,41,41,301,302,303,41,41,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,46,305,306,307,46,41,41},
                {48,41,401,402,402,402,402,402,403,41,41,102,41,41,41,41,41,341,342,343,41,41,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,44,345,346,347,44,41,41},
                {41,41,441,442,442,442,442,442,443,41,41,102,41,41,41,45,207,208,208,208,209,48,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,207,208,208,208,209,41,41},
                {207,208,208,208,208,208,208,208,208,208,209,102,48,41,41,44,247,132,248,248,249,46,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,249,48,41},
                {247,248,248,248,248,248,248,248,248,248,249,102,41,41,45,45,247,248,132,248,249,46,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,132,248,249,41,41},
                {247,248,248,248,248,248,248,248,248,248,249,102,41,41,42,45,247,248,248,248,249,46,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,132,249,41,41},
                {247,248,248,248,248,248,248,248,248,248,249,102,41,50,45,42,247,248,248,132,249,46,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,249,41,41},
                {247,248,248,248,248,248,248,248,248,248,249,102,41,41,41,45,247,248,248,248,249,46,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,245,282,282,283,247,248,132,248,249,41,48},
                {247,248,248,248,248,248,248,248,248,248,249,102,41,41,41,46,210,248,248,248,211,209,281,282,282,282,282,282,282,282,282,282,282,282,282,282,282,282,282,283,207,208,208,210,248,248,248,249,41,41},
                {287,288,288,288,288,250,248,251,288,288,289,102,207,208,208,210,248,248,248,248,248,211,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,210,248,248,248,248,248,248,249,41,41},
                {141,141,141,141,141,145,146,147,141,141,141,142,247,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,129,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,41,41},
                {181,181,181,181,181,185,186,187,181,181,181,182,247,248,248,248,248,248,129,132,248,248,248,248,248,132,248,248,248,248,248,248,248,248,248,132,248,248,248,248,248,248,248,132,248,248,248,249,48,41},
                {221,221,221,221,221,225,226,227,221,221,221,222,247,248,129,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,251,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,289,41,41},
                {242,242,242,243,207,210,248,211,208,208,208,208,210,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,251,289,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41},
                {242,242,242,243,247,248,131,248,248,248,248,248,248,248,132,248,248,248,248,248,248,248,248,248,248,251,288,288,288,289,41,41,41,41,41,41,41,48,41,41,41,41,50,41,50,213,214,214,214,215},
                {242,242,242,243,287,288,288,288,288,288,288,288,288,288,250,248,248,129,248,248,248,248,248,248,251,289,41,41,41,41,41,41,52,52,41,41,41,41,41,41,41,41,41,41,41,253,254,254,254,255},
                {242,242,242,205,202,202,202,202,202,202,202,202,203,48,247,248,248,248,248,248,248,248,248,251,289,41,41,41,41,41,48,41,41,52,52,41,41,41,41,41,41,41,41,50,41,253,254,254,254,255},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,41,247,248,248,248,248,248,248,248,251,289,521,522,522,522,522,522,522,522,522,522,522,522,522,522,522,522,522,522,522,523,41,253,254,254,254,255},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,48,247,248,248,248,248,248,248,248,249,41,561,562,562,562,562,562,562,562,562,562,562,562,562,562,562,562,562,562,562,563,41,253,254,254,254,255},
                {121,242,242,245,282,282,282,282,282,282,282,282,283,41,247,248,248,131,248,248,248,248,249,41,561,562,562,565,602,602,602,602,602,602,602,602,602,602,602,602,602,564,562,563,41,293,294,294,294,295},
                {121,242,242,243,207,208,208,208,208,208,208,208,208,208,210,248,248,248,248,248,248,248,249,41,561,562,562,563,41,41,41,41,41,41,41,41,41,41,41,41,41,561,562,563,41,43,41,41,41,41},
                {121,242,242,243,247,248,132,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,48,561,562,567,563,41,41,42,41,41,41,41,41,50,41,41,41,41,561,562,563,41,41,41,41,41,41},
                {121,242,245,283,210,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,41,561,567,567,563,41,50,41,41,41,41,41,41,41,41,41,51,41,561,562,525,522,522,523,41,41,41},
                {242,242,243,210,248,248,248,248,248,248,248,131,248,248,248,248,248,248,248,248,248,248,249,41,561,567,567,563,41,41,41,41,41,41,42,41,41,41,41,41,41,561,562,562,562,562,563,41,41,41},
                {301,303,247,248,248,132,248,248,248,248,248,248,248,248,248,248,132,248,248,248,248,248,249,41,561,567,567,525,522,522,522,522,528,44,41,521,522,522,522,522,522,524,562,562,562,562,563,41,41,41},
                {341,343,247,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,41,601,602,602,602,602,602,602,602,608,41,44,606,602,602,602,602,602,602,602,607,569,562,563,41,41,41},
                {41,52,287,288,288,288,288,288,288,288,288,288,288,250,248,248,248,251,288,288,288,288,289,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,50,41,41,41,41,41,561,562,563,41,41,41},
                {41,52,287,288,288,288,288,288,288,288,288,288,288,250,248,248,248,251,288,288,288,288,289,41,41,41,41,41,41,41,41,41,41,41,41,41,41,41,50,41,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,205,203,41,41,41,41,247,248,248,248,249,41,48,41,41,41,41,41,41,48,41,41,41,41,207,208,208,208,208,208,208,208,209,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,205,203,48,41,48,247,248,248,248,249,41,41,41,41,41,41,41,41,41,41,41,207,208,210,248,248,248,248,248,248,248,211,209,41,41,41,561,562,563,41,52,41},
                {242,242,242,242,242,242,242,242,242,205,203,41,41,247,248,248,248,249,41,41,41,48,41,41,41,41,41,207,208,210,248,248,248,248,248,132,248,248,248,248,249,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,205,41,48,247,248,248,248,249,48,41,41,41,41,41,41,41,207,210,248,248,248,248,248,248,248,248,248,248,248,248,249,41,41,41,561,562,563,41,52,41},
                {242,242,242,242,242,242,242,242,242,242,242,205,203,247,130,248,248,211,208,208,208,208,208,208,208,208,210,248,132,248,248,248,248,248,248,248,132,248,248,248,249,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,130,248,130,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,41,41,41,561,562,563,52,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,251,288,288,288,288,288,288,288,288,250,248,132,248,132,248,248,248,248,248,132,248,251,288,289,51,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,249,201,202,202,202,202,202,202,203,287,288,288,288,288,288,288,288,288,250,248,248,249,41,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,130,248,248,249,241,242,242,242,242,242,242,205,202,202,202,202,202,202,202,202,203,247,248,251,289,41,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,249,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,249,48,41,41,41,41,51,561,562,563,41,41,41},
                {242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,248,248,249,241,242,242,242,242,242,242,242,242,242,242,242,242,242,242,242,243,247,248,249,48,41,41,41,41,41,561,562,563,41,41,46},
                {242,242,242,242,242,242,245,282,282,282,282,282,283,247,248,248,248,249,281,282,282,282,282,282,282,282,282,282,282,282,282,282,282,282,283,247,248,249,41,41,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,242,245,283,207,208,208,208,208,208,210,248,248,248,211,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,208,210,248,249,41,249,41,41,41,41,561,562,563,41,41,41},
                {242,242,242,242,245,283,207,210,248,248,248,248,248,248,248,132,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,249,521,522,522,522,522,522,524,562,525,522,522,522},
                {242,242,242,242,243,48,247,248,248,248,248,248,132,248,248,248,248,248,248,248,248,132,248,248,248,248,129,248,248,248,248,248,248,248,248,248,248,249,561,567,567,567,567,567,567,572,567,567,567,567},
                {242,242,242,242,243,41,287,250,248,248,248,248,248,248,248,248,132,248,248,248,248,248,248,248,248,248,248,248,248,248,248,248,129,248,248,248,248,249,561,567,567,567,567,567,567,567,567,567,567,567},
                {242,242,242,242,243,41,41,287,288,288,288,288,288,250,248,248,248,251,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,288,289,561,567,567,567,565,607,607,607,607,607,607,607},
                {242,242,242,242,243,41,41,41,41,41,41,41,41,247,248,248,248,249,41,41,41,41,48,41,41,41,41,41,41,52,41,41,41,41,41,41,41,41,561,567,567,567,563,46,41,41,41,41,41,41},
                {242,242,242,242,243,48,41,41,41,41,41,41,41,247,248,132,248,249,41,49,361,362,362,362,362,362,362,362,363,41,52,41,41,41,41,41,48,41,561,567,567,567,563,41,42,41,41,41,41,52},
                {242,242,242,245,283,41,41,41,41,41,41,49,52,247,248,248,248,249,41,41,401,402,402,402,402,402,402,402,403,52,41,296,41,41,41,41,41,42,561,567,567,567,563,41,41,44,41,46,46,41},
                {242,242,245,283,41,41,41,41,41,41,52,41,41,247,248,248,248,249,41,41,406,402,402,402,402,402,402,402,403,48,41,46,41,41,48,41,41,42,561,567,567,567,563,41,41,41,41,41,41,41},
                {242,242,243,48,41,41,48,41,41,41,41,41,41,287,250,248,251,289,41,41,406,402,402,402,402,402,402,402,403,41,41,41,41,41,41,41,41,41,561,567,567,567,563,50,41,41,41,46,41,41}
        };
    }

    public int[][] getTerrain() {
        return tab;
    }

    public boolean dansTerrain(int x, int y){
        return (0 <= x && x < 50 && 0 <= y && y < 50);
    }

    public boolean obstacle(int x, int y){
        return (tab[y][x] == 561 || tab[y][x] == 562);
    }
}

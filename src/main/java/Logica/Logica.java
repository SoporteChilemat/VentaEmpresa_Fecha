package Logica;

import Clases.ActualizaCodigoPrecio;
import Clases.ClienteVE;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import Clases.ErrorExito;
import Clases.Factura;
import Clases.Flete;
import Clases.Maestra;
import Clases.NotaCredito;
import Clases.OrdenCompra;
import Clases.PareoManual;
import Clases.PorcentajeProveedorRebate;
import Clases.Producto;
import Clases.ProductoNotaCredito;
import Clases.ProductoOC;
import Clases.SumasNumeroOC;
import DAO.clientesDAO;
import static DAO.clientesDAO.vendedorCliente;
import DAO.facturaDAO;
import static DAO.facturaDAO.eliminarFactura;
import static DAO.facturaDAO.insertFactura;
import static DAO.facturaDAO.selectFacturaPorFolio;
import DAO.fleteDAO;
import static DAO.notaCreditoDAO.insertNotaCredito;
import static DAO.notaCreditoDAO.selectNotaCredito;
import static DAO.ordenCompraDAO.insertOrdenCompra;
import static DAO.ordenCompraDAO.selectOrdenCompra;
import DAO.productoDAO;
import static DAO.productoDAO.eliminarProducto;
import static DAO.productoDAO.insertProducto;
import static DAO.productoNotaCreditoDAO.insertProductoNotaCredito;
import static DAO.productoNotaCreditoDAO.selectProductoNotaCreditoPorFolio;
import static DAO.productoOCDAO.insertProductoOC;
import static Logica.Logica.arrNombresVendedores;
import Principal.Principal;
import static Principal.Principal.arrReportes;
import static Principal.Principal.arrReportes3;
import static Principal.Principal.jComboBox1;
import static Principal.Principal.jComboBox2;
import static Principal.Principal.jComboBox3;
import static Principal.Principal.jComboBox4;
import static Principal.Principal.jLabel10;
import static Principal.Principal.jLabel12;
import static Principal.Principal.jLabel14;
import static Principal.Principal.jLabel16;
import static Principal.Principal.jLabel18;
import static Principal.Principal.jLabel20;
import static Principal.Principal.jLabel23;
import static Principal.Principal.jLabel4;
import static Principal.Principal.jLabel5;
import static Principal.Principal.jLabel6;
import static Principal.Principal.jLabel8;
import static Principal.Principal.jTable1;
import static Principal.Principal.jTable2;
import static Principal.Principal.jTable3;
import static Principal.Principal.jTable4;
import static Principal.Principal.jTable6;
import static Principal.Principal.jTextField2;
import static Principal.Principal.jTextField4;
import static Principal.Principal.jTextField5;
import static Principal.Principal.jTextField6;
import static Principal.Principal.me;
import static Principal.Principal.rSDateChooser1;
import static Principal.Principal.rSDateChooser2;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.codec.EncoderException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.StringReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static DAO.maestraDAO.selectCostoFinalCodigoMaestra;
import DAO.notaCreditoDAO;
import static DAO.porcentajeProveedorRebateDAO.selectPorcentajeXProveedorRebateLike;
import static DAO.productoOCDAO.productoOC;
import static DAO.productoOCDAO.productoOCPorCodigoOC;
import Principal.IntComparator;
import Principal.MenuExcelDialog;
import static Principal.MenuExcelDialog.ejecucion1;
import static Principal.MenuExcelDialog.ejecucion2;
import static Principal.MenuExcelDialog.ejecucion3;
import static Principal.Principal.arrReportes2;
import static Principal.Principal.jCheckBox1;
import static Principal.Principal.jCheckBox2;
import static Principal.Principal.jCheckBox3;
import static Principal.Principal.jCheckBox4;
import static Principal.Principal.jComboBox5;
import static Principal.Principal.jTable5;
import static Principal.Principal.jTable7;
import static Principal.Principal.rSDateChooser6;
import static Principal.Principal.rSDateChooser7;
import Principal.VentanaLogin;
import static Principal.VentanaLogin.nombrex;
import Principal.VentanaPareo;
import java.awt.Dimension;
import java.io.FileWriter;
import java.util.concurrent.CompletableFuture;
import javax.swing.BoxLayout;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.awt.Color;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

public class Logica {

    public static ArrayList<ErrorExito> arrErrorExito;
    public static ArrayList<String> arrNombresVendedores;
    public static ArrayList<String> arrNumeroOC;
    public static Object fila[];
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ArrayList<Producto> arrProducto;
    public static String buscaGDT;
    public static int contError;
    public static boolean boolOrigen;
    public static boolean insertOrdenCompra;
    public static OrdenCompra selectOrdenCompra;
    public static int size0;
    public static int size01;
    public static int size02;
    public static int size03;
    public static int size04;
    public static int size05;
    public static int sumaCargar;

    public static int porcentaje0;
    public static int porcentaje01;
    public static int porcentaje02;
    public static int porcentaje03;
    public static int porcentaje04;
    public static int porcentaje05;
    public static ArrayList<Factura> arrFacturas;
    public static ArrayList<Factura> arrFacturasF;
    public static ArrayList<SumasNumeroOC> arrSumasNumeroOC;
    public static ArrayList<SumasNumeroOC> arrSumasNumeroOCF;
    public static ArrayList<Producto> selectProductosPorFolio;
    public static ArrayList<Producto> selectProductosPorFolioF;
    public static DefaultTableModel model;

    public static String numeroOC = "";
    public static Double sumaCostoTotal = 0.0;

    public static int dato;

    public static void cargaTablaLocal() throws IOException, SQLException {
        CompletableFuture.runAsync(() -> {
            Principal.newJFrame.jTabbedPane1.setVisible(false);
            Principal.newJFrame.jPanel15.setVisible(true);

            Principal.newJFrame.jProgressBar1.setMaximum(350);
            Principal.newJFrame.jProgressBar1.setValue(0);
        }).thenRunAsync(new Runnable() {
            @Override
            public void run() {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                System.out.println("AH!");
                arrNumeroOC = new ArrayList<>();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
                arrFacturas = new ArrayList<>();
                selectProductosPorFolio = new ArrayList<>();
                arrSumasNumeroOC = new ArrayList<>();

                if (VentanaLogin.nombre.equals("MOYRIC")) {
                    productoDAO.prueba("52", "MOYRIC", "");
                    arrSumasNumeroOC = productoDAO.prueba2("52", "MOYRIC", "");
                } else if (VentanaLogin.nombre.equals("ROJICN")) {
                    productoDAO.prueba("52", "ROJICN", "");
                    arrSumasNumeroOC = productoDAO.prueba2("52", "ROJICN", "");
                } else {
                    productoDAO.prueba("52", "", nombrex);
                    arrSumasNumeroOC = productoDAO.prueba2("52", "", nombrex);
                }

//                System.out.println("arrFacturas.size() " + arrFacturas.size());
//                System.out.println("arrSumasNumeroOC.size() " + arrSumasNumeroOC.size());
//                System.out.println("selectProductosPorFolio.size() " + selectProductosPorFolio.size());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
                arrFacturasF = new ArrayList<>();
                selectProductosPorFolioF = new ArrayList<>();
                arrSumasNumeroOCF = new ArrayList<>();

                if (VentanaLogin.nombre.equals("MOYRIC")) {
                    productoDAO.prueba("GDT", "MOYRIC", "");
                    arrSumasNumeroOCF = productoDAO.prueba2("GDT", "MOYRIC", "");
                } else if (VentanaLogin.nombre.equals("ROJICN")) {
                    productoDAO.prueba("GDT", "ROJICN", "");
                    arrSumasNumeroOCF = productoDAO.prueba2("GDT", "ROJICN", "");
                } else {
                    productoDAO.prueba("GDT", "", nombrex);
                    arrSumasNumeroOCF = productoDAO.prueba2("GDT", "", nombrex);
                }

//                System.out.println("arrFacturasF.size() " + arrFacturasF.size());
//                System.out.println("arrSumasNumeroOCF.size() " + arrSumasNumeroOCF.size());
//                System.out.println("selectProductosPorFolioF.size() " + selectProductosPorFolioF.size());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ArrayList<NotaCredito> selectNotaCredito = null;
                try {
                    selectNotaCredito = selectNotaCredito(VentanaLogin.tipo, VentanaLogin.nombrex);
//                    System.out.println("-1");
                } catch (IOException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ArrayList<Flete> selectFlete = null;
                try {
                    selectFlete = fleteDAO.selectFlete(VentanaLogin.tipo, VentanaLogin.nombrex);
//                    System.out.println("-1");
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                size0 = selectProductosPorFolio.size();
                size01 = selectProductosPorFolioF.size();
                size02 = arrFacturas.size();
                size03 = arrFacturasF.size();
                size04 = selectNotaCredito.size();
                size05 = selectFlete.size();
                sumaCargar = size0 + size01 + size02 + size03 + size04 + size05;

                porcentaje0 = (size0 * 100 / sumaCargar);
////                System.out.println("porcentaje0 " + porcentaje0);
                porcentaje01 = size01 * 100 / sumaCargar;
////                System.out.println("porcentaje01 " + porcentaje01);
                porcentaje02 = size02 * 100 / sumaCargar;
////                System.out.println("porcentaje02 " + porcentaje02);
                porcentaje03 = size03 * 100 / sumaCargar;
////                System.out.println("porcentaje03 " + porcentaje03);
                porcentaje04 = size04 * 100 / sumaCargar;
////                System.out.println("porcentaje04 " + porcentaje04);
                porcentaje05 = size05 * 100 / sumaCargar;
////                System.out.println("porcentaje05 " + porcentaje05);
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA FOLIO">
////                System.out.println(selectProductosPorFolio.size());
//                System.out.println("A");
                fila = new Object[18];
                model = (DefaultTableModel) jTable1.getModel();

                AtomicInteger index = new AtomicInteger(1);
                selectProductosPorFolio.forEach((Producto producto) -> {
                    int currentIndex = index.getAndIncrement();
                    int progressBarValue = (currentIndex * porcentaje0) / size0 + 250;
                    Principal.newJFrame.jProgressBar1.setValue(progressBarValue);
                    String costoUnitarioStr = producto.getCostoUnitario();
                    double costoUnitario = Double.parseDouble(costoUnitarioStr);
                    double costoTotal = costoUnitario * Double.parseDouble(producto.getCantidad());
                    String netoUnitarioStr = producto.getPrecioUnitario();
                    double netoUnitario = Double.parseDouble(netoUnitarioStr);
                    double netoTotal = Double.parseDouble(producto.getPrecioTotal());
                    String folio = producto.getFolio();
                    String fechaEmision = null;
                    String fechaReferencia = null;
                    String folioReferencia = null;
                    String rutCliente = null;
                    String ocCliente = null;
                    String vendedor = null;
                    String vendedor2 = null;

                    for (Factura factura : arrFacturas) {
                        if (folio.equals(factura.getFolio())) {
                            fechaEmision = factura.getFechaEmision();
                            fechaReferencia = factura.getFechaReferencia();
                            folioReferencia = factura.getFolioReferencia();
                            rutCliente = factura.getRutCliente();
                            ocCliente = factura.getOcCliente();
                            vendedor = factura.getVendedor();
                            vendedor2 = factura.getVendedor2();
                            break;
                        }
                    }

                    Object[] row = {
                        fechaEmision,
                        fechaReferencia,
                        folio,
                        folioReferencia,
                        rutCliente,
                        ocCliente,
                        producto.getCodigo(),
                        producto.getCantidad(),
                        producto.getDescripcion(),
                        producto.getUnidad(),
                        formatCurrency(costoUnitario),
                        formatCurrency(netoUnitario),
                        formatCurrency(costoTotal),
                        formatCurrency(netoTotal),
                        formatCurrency(netoTotal - costoTotal),
                        new DecimalFormat("#.##").format(((netoUnitario - costoUnitario) / costoUnitario) * 100) + "%",
                        vendedor,
                        vendedor2
                    };

                    model.addRow(row);
                });

                ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable1);

                jTable1.setRowHeight(35);
                jTable1.setShowHorizontalLines(true);
                jTable1.setShowVerticalLines(true);

                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                int columnCount = jTable1.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                jTable1.getColumn("Costo Unitario").setCellRenderer(new CustomRenderer1(jTable1, VentanaLogin.bool));
                jTable1.getColumn("Costo Unitario").setCellEditor(new CustomEditor1(jTable1, VentanaLogin.bool));
                jTable1.getColumn("Utilidad").setCellRenderer(new CustomRenderer5());
                jTable1.getColumn("Margen").setCellRenderer(new CustomRenderer5());
                jTable1.getColumnModel().getColumn(10).setPreferredWidth(250);
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA FACTURA">
////                System.out.println(selectProductosPorFolioF.size());
//                System.out.println("B");
                fila = new Object[20];
                model = (DefaultTableModel) jTable6.getModel();

                AtomicInteger at = new AtomicInteger(1);
                selectProductosPorFolioF.stream().forEach((Producto get) -> {
                    int x = Integer.parseInt(at.toString());
                    int name = (x * porcentaje01) / size01;

////                    System.out.println("selectProductosPorFolioF namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename " + name);
                    Principal.newJFrame.jProgressBar1.setValue(250 + porcentaje0 + name);

//                    Producto get = selectProductosPorFolioF.get(i);
                    double costoUnitario = Double.valueOf(get.getCostoUnitario());
                    double costoTotal = Double.valueOf(get.getCostoUnitario()) * Double.valueOf(get.getCantidad());

                    double netoUnitario = Double.parseDouble(get.getPrecioUnitario());
                    double netoTotal = Double.valueOf(get.getPrecioTotal());

                    String folio = get.getFolio();
////                    System.out.println("folio " + folio);

                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[0] = factura.getFechaEmision();
                        }
                    });

                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[1] = factura.getFechaReferencia();
                        }
                    });

                    fila[2] = folio;

                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[3] = factura.getFolioReferencia();
                        }
                    });

                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[4] = factura.getRutCliente();
                        }
                    });

                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[5] = factura.getOcCliente();
                        }
                    });

                    fila[6] = get.getCodigo();
                    fila[7] = get.getCantidadOC();
                    fila[8] = get.getCantidad();
                    fila[9] = get.getDescripcion();
                    fila[10] = get.getUnidad();

                    Locale chileLocale = new Locale("es", "CL");
                    NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);
                    String format = nf.format(costoUnitario);
                    String[] split = format.split(",");

                    try {
                        fila[11] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            fila[11] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            fila[11] = "$ " + split[0];
                        }
                    }

                    format = nf.format(netoUnitario);
                    split = format.split(",");

                    try {
                        fila[12] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            fila[12] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            fila[12] = "$ " + split[0];
                        }
                    }

                    format = nf.format(costoTotal);
                    split = format.split(",");

                    try {
                        fila[13] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            fila[13] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            fila[13] = "$ " + split[0];
                        }
                    }

                    format = nf.format(netoTotal);
                    split = format.split(",");

                    try {
                        fila[14] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            fila[14] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            fila[14] = "$ " + split[0];
                        }
                    }

                    format = nf.format(netoTotal - costoTotal);
                    split = format.split(",");

                    try {
                        fila[15] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            fila[15] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            fila[15] = "$ " + split[0];
                        }
                    }

                    fila[16] = new DecimalFormat("#.##").format(((netoUnitario - costoUnitario) / costoUnitario) * 100) + "%";
                    arrFacturasF.stream().forEach((Factura factura) -> {
                        String folio2 = factura.getFolio();
                        if (folio.equals(folio2)) {
                            fila[17] = factura.getVendedor();
                        }
                    });

                    fila[18] = get.getNumeroOC();

                    arrNumeroOC.add(get.getNumeroOC());

                    model.addRow(fila);
                    at.getAndIncrement();
                });

                ((DefaultTableCellRenderer) jTable6.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable6);

                jTable6.setRowHeight(35);
                jTable6.setShowHorizontalLines(true);
                jTable6.setShowVerticalLines(true);

                renderer = new DefaultTableCellRenderer();
                columnCount = jTable6.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable6.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                jTable6.getColumn("Costo Unitario").setCellRenderer(new CustomRenderer1(jTable6, VentanaLogin.bool));
                jTable6.getColumn("Costo Unitario").setCellEditor(new CustomEditor1(jTable6, VentanaLogin.bool));

                jTable6.getColumn("Utilidad").setCellRenderer(new CustomRenderer5());

                jTable6.getColumn("Margen").setCellRenderer(new CustomRenderer5());

                jTable6.getColumnModel().getColumn(11).setPreferredWidth(250);

                HashSet hs = new HashSet();
                hs.addAll(arrNumeroOC);
                arrNumeroOC.clear();
                arrNumeroOC.addAll(hs);

                jComboBox4.removeAllItems();
                jComboBox4.addItem("-");

                for (int i = 0; i < arrNumeroOC.size(); i++) {
                    String get = arrNumeroOC.get(i);
                    jComboBox4.addItem(get);
                }
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA RESUMEN">
//                System.out.println("C");
                arrNombresVendedores = new ArrayList<>();
                ArrayList<String> arrOrigenes = new ArrayList<>();

                Object[] filaTabla2 = new Object[18];
                DefaultTableModel modelTabla2 = (DefaultTableModel) jTable2.getModel();

                AtomicInteger atz = new AtomicInteger(0);
                arrFacturas.stream().forEach((Factura factura) -> {
                    try {
                        numeroOC = "";
                        sumaCostoTotal = 0.0;

                        SumasNumeroOC get = arrSumasNumeroOC.get(atz.get());
                        numeroOC = get.getNumeroOC();
                        sumaCostoTotal = get.getSuma();

                        int andIncrement = atz.getAndIncrement();
                        dato = (andIncrement * porcentaje02) / size02;

////                        System.out.println("arrFacturas namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename " + dato);
                        Principal.newJFrame.jProgressBar1.setValue(250 + porcentaje0 + porcentaje01 + dato);

////                        System.out.println("factura.getFolio() " + factura.getFolio());
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(factura.getFechaEmision());
                        filaTabla2[0] = date1;
                        filaTabla2[1] = factura.getFolio();
                        filaTabla2[2] = factura.getRazonSocial();
                        filaTabla2[3] = factura.getRutCliente();
                        filaTabla2[4] = factura.getVendedor();

                        arrNombresVendedores.add(factura.getVendedor());
                        try {
                            String vendedor2 = factura.getVendedor2();
                            if (vendedor2.equals("VICTOR")) {
                                arrNombresVendedores.add(factura.getVendedor2());
                            }
                        } catch (Exception ex) {

                        }
                        Locale chileLocale = new Locale("es", "CL");
                        NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

                        String format = nf.format(sumaCostoTotal);
                        String[] split = format.split(",");

                        try {
                            filaTabla2[5] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[5] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[5] = "$ " + split[0];
                            }
                        }

                        format = nf.format(Double.valueOf(factura.getMontoNeto()));
                        split = format.split(",");

                        try {
                            filaTabla2[6] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[6] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[6] = "$ " + split[0];
                            }
                        }

                        format = nf.format(Double.valueOf(factura.getMontoNeto()) - sumaCostoTotal);
                        split = format.split(",");

                        try {
                            filaTabla2[7] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[7] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[7] = "$ " + split[0];
                            }
                        }

////                        System.out.println("Double.valueOf(factura.getMontoNeto() " + Double.valueOf(factura.getMontoNeto()));
////                        System.out.println("sumaNetoTotal " + sumaCostoTotal);
                        double name = ((Double.valueOf(factura.getMontoNeto()) - sumaCostoTotal) / sumaCostoTotal) * 100;

                        filaTabla2[8] = new DecimalFormat("#.##").format(name) + "%";
                        filaTabla2[9] = factura.getOrigen();

                        if (numeroOC == null || numeroOC.equals("null")) {
                            filaTabla2[10] = "-";
                        } else {
                            filaTabla2[10] = numeroOC;
                        }

                        filaTabla2[11] = factura.getPagada();
                        filaTabla2[12] = factura.getVendedor2();

                        arrOrigenes.add(factura.getOrigen());

                        modelTabla2.addRow(filaTabla2);

                    } catch (Exception ex) {

                    }
                });

                AtomicInteger at1 = new AtomicInteger(0);
                arrFacturasF.stream().forEach((Factura factura) -> {
                    try {
                        numeroOC = "";
                        sumaCostoTotal = 0.0;

                        SumasNumeroOC get = arrSumasNumeroOCF.get(at1.get());
                        numeroOC = get.getNumeroOC();
                        sumaCostoTotal = get.getSuma();

                        int andIncrement = at1.getAndIncrement();
                        dato = (andIncrement * porcentaje03) / size03;

////                        System.out.println("arrFacturasF namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename " + dato);
                        Principal.newJFrame.jProgressBar1.setValue(250 + porcentaje0 + porcentaje01 + porcentaje02 + dato);

                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(factura.getFechaEmision());
                        filaTabla2[0] = date1;
                        filaTabla2[1] = factura.getFolio();
                        filaTabla2[2] = factura.getRazonSocial();
                        filaTabla2[3] = factura.getRutCliente();
                        filaTabla2[4] = factura.getVendedor();

                        arrNombresVendedores.add(factura.getVendedor());

                        Locale chileLocale = new Locale("es", "CL");
                        NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

                        String format = nf.format(sumaCostoTotal);
                        String[] split = format.split(",");

                        try {
                            filaTabla2[5] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[5] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[5] = "$ " + split[0];
                            }
                        }

                        format = nf.format(Double.valueOf(factura.getMontoNeto()));
                        split = format.split(",");

                        try {
                            filaTabla2[6] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[6] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[6] = "$ " + split[0];
                            }
                        }

                        format = nf.format(Double.valueOf(factura.getMontoNeto()) - sumaCostoTotal);
                        split = format.split(",");

                        try {
                            filaTabla2[7] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla2[7] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla2[7] = "$ " + split[0];
                            }
                        }

////                        System.out.println("Double.valueOf(factura.getMontoNeto() " + Double.valueOf(factura.getMontoNeto()));
////                        System.out.println("sumaNetoTotal " + sumaCostoTotal);
                        double name = ((Double.valueOf(factura.getMontoNeto()) - sumaCostoTotal) / sumaCostoTotal) * 100;

                        filaTabla2[8] = new DecimalFormat("#.##").format(name) + "%";
                        filaTabla2[9] = factura.getOrigen();

                        if (numeroOC == null || numeroOC.equals("null")) {
                            filaTabla2[10] = "-";
                        } else {
                            filaTabla2[10] = numeroOC;
                        }

                        filaTabla2[11] = factura.getPagada();
                        arrOrigenes.add(factura.getOrigen());
                        modelTabla2.addRow(filaTabla2);
                    } catch (Exception ex) {

                    }
                });

                ((DefaultTableCellRenderer) jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable2);

                jTable2.setRowHeight(35);
                jTable2.setShowHorizontalLines(true);
                jTable2.setShowVerticalLines(true);

                renderer = new DefaultTableCellRenderer();
                columnCount = jTable2.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                Set<String> set = new HashSet<>(arrNombresVendedores);
                arrNombresVendedores.clear();
                arrNombresVendedores.addAll(set);

                Set<String> set2 = new HashSet<>(arrOrigenes);
                arrOrigenes.clear();
                arrOrigenes.addAll(set2);

                jComboBox1.removeAllItems();
                jComboBox2.removeAllItems();

                jComboBox1.addItem("Todos");
                jComboBox2.addItem("Todos");

                jComboBox3.removeAllItems();
                jComboBox3.addItem("");

                for (int i = 0; i < arrNombresVendedores.size(); i++) {
                    String get = arrNombresVendedores.get(i);
                    if (!get.equals("")) {
                        jComboBox1.addItem(get);
                        jComboBox3.addItem(get);
                    }
                }

                for (int i = 0; i < arrOrigenes.size(); i++) {
                    String get = arrOrigenes.get(i);
                    if (!get.equals("")) {
                        jComboBox2.addItem(get);
                    }
                }

                jTable2.getColumn("Vendedor").setCellRenderer(new CustomRenderer3(jTable2, VentanaLogin.bool));
                jTable2.getColumn("Vendedor").setCellEditor(new CustomEditor3(jTable2, VentanaLogin.bool));

                jTable2.getColumn("Fecha FA").setCellRenderer(new CustomRenderer4(jTable2, VentanaLogin.bool));
                jTable2.getColumn("Fecha FA").setCellEditor(new CustomEditor4(jTable2, VentanaLogin.bool, 0));

                jTable2.getColumn("Utilidad").setCellRenderer(new CustomRenderer5());

                jTable2.getColumn("Pagada").setCellRenderer(new CustomRenderer6(jTable2, VentanaLogin.bool));
                jTable2.getColumn("Pagada").setCellEditor(new CustomEditor6(jTable2, VentanaLogin.bool));

                jTable2.getColumnModel().getColumn(4).setPreferredWidth(250);
                jTable2.getColumnModel().getColumn(0).setPreferredWidth(180);

                jTable2.getColumnModel().getColumn(11).setMaxWidth(0);
                jTable2.getColumnModel().getColumn(11).setMinWidth(0);
                jTable2.getColumnModel().getColumn(11).setPreferredWidth(0);

//        AutoCompletion.enable(jComboBox3);
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA NOTA DE CREDITO">
//                System.out.println("D");
                Object[] filaTabla3 = new Object[12];
                DefaultTableModel modelTabla3 = (DefaultTableModel) jTable3.getModel();

                AtomicInteger at2 = new AtomicInteger(0);
                selectNotaCredito.stream().forEach((NotaCredito notaCredito) -> {

                    int andIncrement = at2.getAndIncrement();
                    dato = (andIncrement * porcentaje04) / size04;

////                    System.out.println("selectNotaCredito namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename " + dato);
                    Principal.newJFrame.jProgressBar1.setValue(250 + porcentaje0 + porcentaje01 + porcentaje02 + porcentaje03 + dato);

                    Factura selectFacturaPorFolio = null;
                    try {
                        selectFacturaPorFolio = selectFacturaPorFolio(notaCredito.getFolioReferencia());
                    } catch (IOException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);

                    } catch (SQLException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    filaTabla3[0] = notaCredito.getFecha();
                    filaTabla3[1] = notaCredito.getCliente();
                    filaTabla3[2] = notaCredito.getFolio();
                    filaTabla3[3] = notaCredito.getFolioReferencia();

                    double sumaCostoUnitario = 0.0;
                    String folioReferencia = notaCredito.getFolioReferencia();
                    ArrayList<ProductoNotaCredito> selectProductoNotaCreditoPorFolio;

                    try {
                        selectProductoNotaCreditoPorFolio = selectProductoNotaCreditoPorFolio(notaCredito.getFolio());

                        for (int t = 0; t < selectProductoNotaCreditoPorFolio.size(); t++) {
                            String costoUnitario = "";
                            double costoUnitarioTotal = 0.0;
                            ProductoNotaCredito productoNotaCredito = selectProductoNotaCreditoPorFolio.get(t);
                            String codigo = productoNotaCredito.getCodigo().replace("V.E.", "");
                            String descripcion = productoNotaCredito.getDescripcion();

                            for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
                                String folio = jTable1.getModel().getValueAt(i, 2).toString();
                                String codigo1 = jTable1.getModel().getValueAt(i, 6).toString();
                                String descipcionTabla = jTable1.getModel().getValueAt(i, 8).toString();

//                                System.out.println("codigo " + codigo);
//                                System.out.println("codigoNC " + codigoNC);
//                                System.out.println("folio " + folio);
//                                System.out.println("folioReferencia " + folioReferencia);
                                if (folio.equals(folioReferencia) && (descipcionTabla.contains(descripcion) || descripcion.contains(descipcionTabla) || codigo1.contains(codigo))) {
                                    costoUnitario = jTable1.getModel().getValueAt(i, 10).toString();
                                    costoUnitarioTotal = convertStringToDouble(costoUnitario) * Double.valueOf(productoNotaCredito.getCantidad());
////                                    System.out.println("--->");
////                                    System.out.println(Double.valueOf(costoUnitario));
////                                    System.out.println(Double.valueOf(productoNotaCredito.getCantidad()));
                                    break;
                                }
                            }

                            for (int i = 0; i < jTable6.getModel().getRowCount(); i++) {
                                String folio = jTable6.getModel().getValueAt(i, 2).toString();
                                String codigo2 = jTable6.getModel().getValueAt(i, 6).toString();
                                String descipcionTabla2 = jTable6.getModel().getValueAt(i, 6).toString();

                                if (folio.equals(folioReferencia) && (descipcionTabla2.contains(descripcion) || descripcion.contains(descipcionTabla2) || codigo2.contains(codigo))) {
                                    costoUnitario = jTable6.getModel().getValueAt(i, 11).toString();
                                    costoUnitarioTotal = convertStringToDouble(costoUnitario) * Double.valueOf(productoNotaCredito.getCantidad());
////                                    System.out.println("--->");
////                                    System.out.println(Double.valueOf(costoUnitario));
////                                    System.out.println(Double.valueOf(productoNotaCredito.getCantidad()));
                                    break;
                                }
                            }

                            sumaCostoUnitario = sumaCostoUnitario + costoUnitarioTotal;
                        }
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Locale chileLocale = new Locale("es", "CL");
                    NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);
                    String format = nf.format(Double.valueOf(sumaCostoUnitario));
                    String[] split = format.split(",");

                    try {
                        filaTabla3[4] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla3[4] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla3[4] = "$ " + split[0];
                        }
                    }

                    String origen = selectFacturaPorFolio.getOrigen();

                    format = nf.format(Double.valueOf(notaCredito.getNeto()));
                    split = format.split(",");

                    try {
                        filaTabla3[5] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla3[5] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla3[5] = "$ " + split[0];
                        }
                    }

                    if (notaCredito.getMotivo().equals("ANULA")) {
                        if (origen.equals("Local")) {
                            for (int i = 0; i < jTable2.getModel().getRowCount(); i++) {
                                String folio = jTable2.getModel().getValueAt(i, 1).toString();
                                if (folio.equals(notaCredito.getFolioReferencia())) {
                                    String utilidad = jTable2.getModel().getValueAt(i, 7).toString();
                                    filaTabla3[6] = utilidad;
                                    break;
                                }
                            }
                        } else {
                            for (int i = 0; i < jTable2.getModel().getRowCount(); i++) {
                                String folio = jTable2.getModel().getValueAt(i, 1).toString();
                                if (folio.equals(notaCredito.getFolioReferencia())) {
                                    String utilidad = jTable2.getModel().getValueAt(i, 7).toString();
                                    filaTabla3[6] = utilidad;
                                    break;
                                }
                            }
                        }
                    } else if (notaCredito.getMotivo().equals("DIFERENCIA PRECIO") || notaCredito.getMotivo().equals("ESPECIAL")) {
                        try {
                            filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla3[6] = "$ " + split[0];
                            }
                        }
                    } else if (notaCredito.getMotivo().equals("DEVOLUCION")) {
                        if (origen.equals("Local")) {
////                            System.out.println("DEVOLUCION LOCAL");
                            double suma = 0.0;
                            try {
                                selectProductoNotaCreditoPorFolio = selectProductoNotaCreditoPorFolio(notaCredito.getFolio());
                                String folio = notaCredito.getFolioReferencia();
////                                System.out.println("--> folio " + folio);

                                int size = selectProductoNotaCreditoPorFolio.size();
////                                System.out.println("size " + size);

                                for (int i = 0; i < selectProductoNotaCreditoPorFolio.size(); i++) {
                                    ProductoNotaCredito get = selectProductoNotaCreditoPorFolio.get(i);
                                    String codigo = get.getCodigo().replace("V.E.", "");;
                                    String descripcion = get.getDescripcion();
                                    String cantidad = get.getCantidad();

                                    for (int h = 0; h < jTable1.getModel().getRowCount(); h++) {
                                        String folio1 = jTable1.getModel().getValueAt(h, 2).toString();
                                        String codigo1 = jTable1.getModel().getValueAt(h, 6).toString();
                                        String descipcionTabla = jTable1.getModel().getValueAt(h, 8).toString();

////                                        System.out.println("folio " + folio);
////                                        System.out.println("folio1 " + folio1);
////                                        System.out.println("codigo " + codigo);
////                                        System.out.println("codigo1 " + codigo1);
                                        if (folio1.equals(folio) && (descipcionTabla.contains(descripcion) || descripcion.contains(descipcionTabla) || codigo1.contains(codigo))) {
                                            String utilidad = jTable1.getModel().getValueAt(h, 14).toString();
                                            Double valueOf = convertStringToDouble(utilidad);
                                            Double valueOf1 = convertStringToDouble(cantidad);

                                            double name = valueOf / valueOf1;
                                            double name1 = name * Double.valueOf(cantidad);

                                            suma = suma + name1;
                                            break;
                                        }
////                                        System.out.println("-> ");
                                    }
////                                    System.out.println("/////////////////////////////");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);

                            } catch (SQLException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            format = nf.format(Double.valueOf(suma));
                            split = format.split(",");

                            try {
                                filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 2);
                            } catch (Exception ex) {
                                try {
                                    filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 1);
                                } catch (Exception exx) {
                                    filaTabla3[6] = "$ " + split[0];
                                }
                            }
                        } else {
////                            System.out.println("DEVOLUCION FABRICA");
                            double suma = 0.0;
                            try {
                                selectProductoNotaCreditoPorFolio = selectProductoNotaCreditoPorFolio(notaCredito.getFolio());
                                String folio = notaCredito.getFolioReferencia();
////                                System.out.println("--> folio " + folio);

                                int size = selectProductoNotaCreditoPorFolio.size();
////                                System.out.println("size " + size);

                                for (int i = 0; i < selectProductoNotaCreditoPorFolio.size(); i++) {
                                    ProductoNotaCredito get = selectProductoNotaCreditoPorFolio.get(i);
                                    String codigo = get.getCodigo().replace("V.E.", "");;
                                    String descripcion = get.getDescripcion();
                                    String cantidad = get.getCantidad();

                                    for (int h = 0; h < jTable6.getModel().getRowCount(); h++) {
                                        String folio1 = jTable6.getModel().getValueAt(h, 2).toString();
                                        String codigo1 = jTable6.getModel().getValueAt(h, 6).toString();
                                        String descipcionTabla = jTable6.getModel().getValueAt(h, 8).toString();

//                                        System.out.println("folio " + folio);
//                                        System.out.println("folio1 " + folio1);
//                                        System.out.println("codigo " + codigo);
//                                        System.out.println("codigo1 " + codigo1);
                                        if (folio1.equals(folio) && (descipcionTabla.contains(descripcion) || descripcion.contains(descipcionTabla) || codigo1.contains(codigo))) {
                                            String utilidad = jTable6.getModel().getValueAt(h, 15).toString();
                                            Double valueOf = convertStringToDouble(utilidad);

                                            String canttidad = jTable6.getModel().getValueAt(h, 8).toString();
                                            Double valueOf1 = convertStringToDouble(canttidad);

                                            double name = valueOf / valueOf1;
                                            double name1 = name * Double.valueOf(cantidad);

                                            suma = suma + name1;
                                            break;
                                        }
////                                        System.out.println("-> ");
                                    }
////                                    System.out.println("/////////////////////////////");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);

                            } catch (SQLException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            format = nf.format(Double.valueOf(suma));
                            split = format.split(",");

                            try {
                                filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 2);
                            } catch (Exception ex) {
                                try {
                                    filaTabla3[6] = "$ " + split[0] + "," + split[1].substring(0, 1);
                                } catch (Exception exx) {
                                    filaTabla3[6] = "$ " + split[0];
                                }
                            }
                        }
                    }

                    filaTabla3[7] = notaCredito.getVendedor();
                    filaTabla3[8] = notaCredito.getMotivo();
                    filaTabla3[9] = selectFacturaPorFolio.getOrigen();

                    for (int i = 0; i < jTable6.getModel().getRowCount(); i++) {
                        String toString = jTable6.getModel().getValueAt(i, 2).toString();
                        if (toString.equals(notaCredito.getFolioReferencia())) {
                            filaTabla3[10] = jTable6.getModel().getValueAt(i, 18).toString();
                            break;
                        }
                    }

                    filaTabla3[11] = notaCredito.getVendedor2();
                    modelTabla3.addRow(filaTabla3);
                });

                ((DefaultTableCellRenderer) jTable3.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable3);

                jTable3.setRowHeight(35);
                jTable3.setShowHorizontalLines(true);
                jTable3.setShowVerticalLines(true);

                renderer = new DefaultTableCellRenderer();
                columnCount = jTable3.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable3.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                jTable3.getColumn("Fecha").setCellRenderer(new CustomRenderer4(jTable3, VentanaLogin.bool));
                jTable3.getColumn("Fecha").setCellEditor(new CustomEditor4(jTable3, VentanaLogin.bool, 1));

                jTable3.getColumnModel().getColumn(0).setPreferredWidth(180);
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA FLETE">
//                System.out.println("E");

                Object[] filaTabla4 = new Object[10];
                DefaultTableModel modelTabla4 = (DefaultTableModel) jTable4.getModel();

                Locale chileLocale = new Locale("es", "CL");
                NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

                AtomicInteger at3 = new AtomicInteger(0);
                selectFlete.stream().forEach((Flete fletex) -> {

                    int andIncrement = at3.getAndIncrement();
                    dato = (andIncrement * porcentaje05) / size05;

////                    System.out.println("selectFlete namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename " + dato);
                    Principal.newJFrame.jProgressBar1.setValue(250 + porcentaje0 + porcentaje01 + porcentaje02 + porcentaje03 + porcentaje04 + dato);

                    filaTabla4[0] = fletex.getFechaFa();
                    filaTabla4[1] = fletex.getNumeroFa();
                    filaTabla4[2] = fletex.getVendedor();

                    String format = nf.format(Double.valueOf(fletex.getMontoFa()));
                    String[] split = format.split(",");

                    try {
                        filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla4[3] = "$ " + split[0];
                        }
                    }

                    format = nf.format(Double.valueOf(fletex.getMontoFaVendedor()));
                    split = format.split(",");

                    try {
                        filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla4[4] = "$ " + split[0];
                        }
                    }
                    filaTabla4[5] = fletex.getObservacion();
                    modelTabla4.addRow(filaTabla4);
                });

                ((DefaultTableCellRenderer) jTable4.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable4);

                jTable4.setRowHeight(60);
                jTable4.setShowHorizontalLines(true);
                jTable4.setShowVerticalLines(true);

                renderer = new DefaultTableCellRenderer();
                columnCount = jTable4.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable4.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                jTable4.getColumn("Observacion").setCellRenderer(new CustomRenderer2(jTable4, VentanaLogin.bool));
                jTable4.getColumn("Observacion").setCellEditor(new CustomEditor2(jTable4, VentanaLogin.bool));

                jTable4.getColumn("Eliminar").setCellRenderer(new CustomRenderer("Eliminar", VentanaLogin.bool));
                jTable4.getColumn("Eliminar").setCellEditor(new CustomEditor("Eliminar", VentanaLogin.bool));

                jTable4.getColumnModel().getColumn(5).setPreferredWidth(400);
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
//<editor-fold defaultstate="collapsed" desc="TABLA COMISIONES">
//                System.out.println("F");

                String nombrex = VentanaLogin.nombrex;
                int tipo = VentanaLogin.tipo;

                double sumaUtilidad1 = 0;
                double sumaUtilidad2 = 0;
                double sumaNeto = 0;

                Object[] filaTabla5 = new Object[4];
                DefaultTableModel modelTabla5 = (DefaultTableModel) jTable5.getModel();

                for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
                    double neto = convertStringToDouble(jTable2.getModel().getValueAt(j, 6).toString());
                    double utilidad = convertStringToDouble(jTable2.getModel().getValueAt(j, 7).toString());

                    if (utilidad > 0) {
                        sumaNeto = sumaNeto + neto;
                    }
                }

                for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                    String toString = jComboBox1.getItemAt(i);
                    if (!toString.equals("EDUARDO VEGA") && !toString.equals("VICTOR ESPINOZA R.") && !toString.equals("CARLOS MATURANA") && !toString.equals("Todos") && !toString.equals("CHERYL BERRIOS")) {
                        double sumaUtilidadNCBono = 0;
                        double sumaUtilidadNCLocal = 0;
                        double sumaUtilidadNC = 0;
                        double sumaUtilidadLocal = 0;
                        double sumaUtilidad = 0;
                        double sumaFlete = 0;
                        double sumaBono = 0;
                        double sumaCostoLocal = 0;
                        double sumaCosto = 0;
                        double sumaCostoNCLocal = 0;
                        double sumaCostoNC = 0;

                        for (int x = 0; x < jTable4.getModel().getRowCount(); x++) {
                            String vendedor = jTable4.getValueAt(x, 2).toString();
                            double monto = convertStringToDouble(jTable4.getValueAt(x, 4).toString());

                            if (toString.equals(vendedor)) {
                                sumaFlete = sumaFlete + monto;
                            }
                        }

                        for (int j = 0; j < jTable3.getModel().getRowCount(); j++) {
                            String fecha = jTable3.getModel().getValueAt(j, 0).toString();
                            String vendedor = jTable3.getModel().getValueAt(j, 7).toString();
                            String origen = jTable3.getModel().getValueAt(j, 9).toString();
                            double costo = convertStringToDouble(jTable3.getModel().getValueAt(j, 4).toString());
                            double utilidad = convertStringToDouble(jTable3.getModel().getValueAt(j, 6).toString());

                            if (toString.equals(vendedor)) {
                                if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(fecha.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(fecha.replace("-", ""))) {
                                    sumaUtilidadNC = sumaUtilidadNC + utilidad;
                                    sumaCostoNC = sumaCostoNC + costo;

                                    if (origen.equals("Local")) {
                                        sumaUtilidadNCLocal = sumaUtilidadNCLocal + utilidad;
                                        sumaCostoNCLocal = sumaCostoNCLocal + costo;
                                    }
                                }
                            }
                        }

                        for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
                            String folio = jTable2.getModel().getValueAt(j, 1).toString();
                            String vendedor = jTable2.getModel().getValueAt(j, 4).toString();
                            double costo = convertStringToDouble(jTable2.getModel().getValueAt(j, 5).toString());
                            double utilidad = convertStringToDouble(jTable2.getModel().getValueAt(j, 7).toString());
                            String margen = jTable2.getModel().getValueAt(j, 8).toString();
                            String origen = jTable2.getModel().getValueAt(j, 9).toString();

                            if (toString.equals(vendedor)) {

                                sumaUtilidad = sumaUtilidad + utilidad;
                                sumaCosto = sumaCosto + costo;

                                String replace = margen.replace("%", "").replace(",", ".");
//                                System.out.println("replace " + replace);
                                Double valueOf = 0.0;
                                try {
                                    valueOf = Double.valueOf(replace);
                                } catch (Exception ex) {

                                }

                                if (valueOf >= 10) {
//                                    System.out.println("valueOf " + valueOf);
                                    sumaBono = sumaBono + utilidad;

                                    for (int r = 0; r < jTable3.getModel().getRowCount(); r++) {
                                        String foliox = jTable3.getValueAt(r, 2).toString();
                                        String vendedorx = jTable3.getValueAt(r, 7).toString();
                                        double utilidadx = convertStringToDouble(jTable3.getModel().getValueAt(r, 6).toString());

                                        if (toString.equals(vendedorx)) {
                                            if (folio.equals(foliox)) {
                                                sumaUtilidadNCBono = sumaUtilidadNCBono + utilidadx;
                                            }
                                        }
                                    }
                                }

                                if (origen.equals("Local")) {
                                    sumaUtilidadLocal = sumaUtilidadLocal + utilidad;
                                    sumaCostoLocal = sumaCostoLocal + costo;
                                }
                            }
                        }

                        double porcentaje = (((sumaUtilidadLocal) - sumaUtilidadNCLocal) / ((sumaCostoLocal) - sumaCostoNCLocal)) * 100;

//                        System.out.println("toString " + toString);
//                        System.out.println("sumaUtilidad " + sumaUtilidad);
//                        System.out.println("porcentaje " + porcentaje);
//                        System.out.println("sumaUtilidadNC " + sumaUtilidadNC);
//                        System.out.println("sumaFlete " + sumaFlete);
//                        System.out.println("sumaBono " + sumaBono);
//                        System.out.println("sumaUtilidadNCBono " + sumaUtilidadNCBono);
                        double name = (sumaUtilidad - sumaUtilidadNC - sumaFlete) * 0.1;

                        double namex = 0.0;
                        if (porcentaje >= 10) {
                            namex = (sumaBono - sumaUtilidadNCBono - sumaFlete) * 0.05;
                        }

//                        System.out.println("name " + name);
//                        System.out.println("namex " + namex);
                        if (toString.equals("FRANCESCA PEREZ") || toString.equals("MARIO BRITO") || toString.equals("JUAN PABLO ARANDA") || toString.equals("CARLOS SEREY")) {
                            sumaUtilidad1 = sumaUtilidad1 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                        }

                        if (toString.equals("GONZALO ORDENES") || toString.equals("SERGIO HIDALGO") || toString.equals("GROVER IBACETA") || toString.equals("CLAUDIA RIQUELME")) {
                            sumaUtilidad2 = sumaUtilidad2 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                        }

                        filaTabla5[0] = toString;

                        String format = nf.format(name);
                        String[] split = format.split(",");

                        try {
                            filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla5[1] = "$ " + split[0];
                            }
                        }

                        format = nf.format(namex);
                        split = format.split(",");

                        try {
                            filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla5[2] = "$ " + split[0];
                            }
                        }

                        format = nf.format(name + namex);
                        split = format.split(",");

                        try {
                            filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                        } catch (Exception ex) {
                            try {
                                filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                            } catch (Exception exx) {
                                filaTabla5[3] = "$ " + split[0];
                            }
                        }

                        if (tipo == 0) {
                            modelTabla5.addRow(filaTabla5);
                        } else {
                            if (nombrex.equals(toString)) {
                                modelTabla5.addRow(filaTabla5);
                            }
                        }
                    }
                }

                double sumaUtilidadTotal = sumaUtilidad1 + sumaUtilidad2;

                double porcentajeVega = ((sumaUtilidad1 * 100) / sumaUtilidadTotal) / 100;
                double porcentajeMaturana = ((sumaUtilidad2 * 100) / sumaUtilidadTotal) / 100;
                double totalVega = 0;
                double totalMaturana = 0;

                if (sumaUtilidadTotal >= 21000000 && sumaUtilidadTotal <= 29999999) {
                    totalVega = 500000 * porcentajeVega;
                    totalMaturana = 500000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 30000000 && sumaUtilidadTotal <= 39999999) {
                    totalVega = 700000 * porcentajeVega;
                    totalMaturana = 700000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 40000000 && sumaUtilidadTotal <= 49999999) {
                    totalVega = 800000 * porcentajeVega;
                    totalMaturana = 800000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 50000000 && sumaUtilidadTotal <= 59999999) {
                    totalVega = 900000 * porcentajeVega;
                    totalMaturana = 900000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 60000000 && sumaUtilidadTotal <= 69999999) {
                    totalVega = 1000000 * porcentajeVega;
                    totalMaturana = 1000000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 70000000 && sumaUtilidadTotal <= 79999999) {
                    totalVega = 1100000 * porcentajeVega;
                    totalMaturana = 1100000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 80000000 && sumaUtilidadTotal <= 89999999) {
                    totalVega = 1200000 * porcentajeVega;
                    totalMaturana = 1200000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 90000000 && sumaUtilidadTotal <= 99999999) {
                    totalVega = 1300000 * porcentajeVega;
                    totalMaturana = 1300000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 100000000 && sumaUtilidadTotal <= 109999999) {
                    totalVega = 1400000 * porcentajeVega;
                    totalMaturana = 1400000 * porcentajeMaturana;
                } else if (sumaUtilidadTotal >= 110000000 && sumaUtilidadTotal <= 119999999) {
                    totalVega = 1500000 * porcentajeVega;
                    totalMaturana = 1500000 * porcentajeMaturana;
                }

                filaTabla5[0] = "EDUARDO VEGA";

                String format = nf.format(totalVega);
                String[] split = format.split(",");

                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[1] = "$ " + split[0];
                    }
                }

                filaTabla5[2] = "";
                filaTabla5[3] = "";

                if (tipo == 0) {
                    modelTabla5.addRow(filaTabla5);
                } else {
                    if (nombrex.equals("EDUARDO VEGA")) {
                        modelTabla5.addRow(filaTabla5);
                    }
                }

                filaTabla5[0] = "CARLOS MATURANA";

                format = nf.format(totalMaturana);
                split = format.split(",");

                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[1] = "$ " + split[0];
                    }
                }

                filaTabla5[2] = "";
                filaTabla5[3] = "";

                if (tipo == 0) {
                    modelTabla5.addRow(filaTabla5);
                } else {
                    if (nombrex.equals("CARLOS MATURANA")) {
                        modelTabla5.addRow(filaTabla5);
                    }
                }

                filaTabla5[0] = "VICTOR ESPINOZA R.";

                format = nf.format(sumaNeto * 0.003);
                split = format.split(",");

                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[1] = "$ " + split[0];
                    }
                }

                filaTabla5[2] = "";
                filaTabla5[3] = "";

                if (tipo == 0) {
                    modelTabla5.addRow(filaTabla5);
                } else {
                    if (nombrex.equals("VICTOR ESPINOZA R.")) {
                        modelTabla5.addRow(filaTabla5);
                    }
                }

                ((DefaultTableCellRenderer) jTable5.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(jTable5);

                jTable5.setRowHeight(25);
                jTable5.setShowHorizontalLines(true);
                jTable5.setShowVerticalLines(true);

                renderer = new DefaultTableCellRenderer();
                columnCount = jTable5.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    jTable5.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                Principal.jLabel27.setText("" + jTable2.getRowCount());
//</editor-fold>
////////////////////////////////////////////////////////////////////////////////
                jComboBox5.removeAllItems();
                for (int i = 0; i < arrNombresVendedores.size(); i++) {
                    String get = arrNombresVendedores.get(i);
                    if (!get.equals("")) {
                        jComboBox5.addItem(get);
                    }
                }
            }
        }).thenRunAsync(() -> {
            Principal.newJFrame.jTabbedPane1.setVisible(true);
            Principal.newJFrame.jPanel15.setVisible(false);
        });
    }

    public static double convertStringToDouble(String s) {
        // Use regex to extract numerical values from the string
        Pattern p = Pattern.compile("\\d{1,3}(\\.\\d{3})*(,\\d+)?|\\d+(,\\d+)?");
        Matcher m = p.matcher(s);

        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group().replaceAll("\\.", "").replace(",", "."));
        }

        // Convert the string of numbers to a double
        double num = Double.parseDouble(sb.toString());

        return num;
    }

    public static void crearExcel() throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Facturas");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.index);
        CellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"FOLIO"});

        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet 
            Row row = spreadsheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++);
                // if rownum is 1 (first row was created before) then set header CellStyle
                if (rownum == 1) {
                    cell.setCellStyle(headerCellStyle);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("ListadoFacturas.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void crearExcel2() throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Facturas2");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.index);
        CellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"FOLIO", "N° ORDEN"});
        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet 
            Row row = spreadsheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++);
                // if rownum is 1 (first row was created before) then set header CellStyle
                if (rownum == 1) {
                    cell.setCellStyle(headerCellStyle);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("ListadoFacturas2.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void crearExcel3() throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("NotasCredito");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.index);
        CellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"FOLIO"});

        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet 
            Row row = spreadsheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++);
                // if rownum is 1 (first row was created before) then set header CellStyle
                if (rownum == 1) {
                    cell.setCellStyle(headerCellStyle);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("ListadoNotasCredito.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void crearExcel4() throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("FacturasNombre");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.index);
        CellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"FOLIO", "NOMBRE"});
        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet 
            Row row = spreadsheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++);
                // if rownum is 1 (first row was created before) then set header CellStyle
                if (rownum == 1) {
                    cell.setCellStyle(headerCellStyle);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("FacturasNombre.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void crearExcel5() throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("NotasCreditoNombre");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.index);
        CellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"FOLIO", "NOMBRE"});
        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet 
            Row row = spreadsheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++);
                // if rownum is 1 (first row was created before) then set header CellStyle
                if (rownum == 1) {
                    cell.setCellStyle(headerCellStyle);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        FileOutputStream out = new FileOutputStream(new File("ListadoNotasCreditoNombre.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void abrirExcel() throws IOException {
        File file = new File("ListadoFacturas.xlsx");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    public static void abrirExcel2() throws IOException {
        File file = new File("ListadoFacturas2.xlsx");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    public static void abrirExcel3() throws IOException {
        File file = new File("ListadoNotasCredito.xlsx");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    public static void abrirExcel4() throws IOException {
        File file = new File("FacturasNombre.xlsx");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    public static void abrirExcel5() throws IOException {
        File file = new File("ListadoNotasCreditoNombre.xlsx");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    public static ArrayList<String>[] convertir(ArrayList<ArrayList<String>> listaDeListas) {
        ArrayList<String> listaA = new ArrayList<String>();
        ArrayList<String> listaB = new ArrayList<String>();
        for (ArrayList<String> lista : listaDeListas) {
            int i = 0;
            for (String elemento : lista) {
                if (i == 0) {
                    listaA.add(elemento);
                } else if (i == 1) {
                    listaB.add(elemento);
                }
                i++;
            }
        }
        return new ArrayList[]{listaA, listaB};
    }

    public static void procedimientoCargarDocumento(int num) throws InterruptedException, MalformedURLException, IOException, EncoderException, TransformerException, SQLException, ParserConfigurationException, SAXException {
        arrErrorExito = new ArrayList<>();

        String rut = "76008058-6";
        String password = "8058";

        String baseURL = "http://enteldte.facturanet.cl/";

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\XMLs");
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("disable-popup-blocking", true);
        prefs.put("download.extensions_to_open", "application/xml");

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--safebrowsing-disable-extension-blacklist");
        options.addArguments("--headless=new");
        options.addArguments("--log-level=3");
        options.addArguments("--silent");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get(baseURL);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"username\"]")));

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(rut);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/form/div[3]/button")).click();

        ArrayList<String>[] convertir = null;
        if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
            convertir = convertir(arrReportes2);
            arrReportes = convertir[0];
        }

        if (num == 0) {
            //<editor-fold defaultstate="collapsed" desc="Acoplar IF">
            System.out.println("arrReportes.size() " + arrReportes.size());
            for (int i = 0; i < arrReportes.size(); i++) {
                contError = 0;
                String folio = null;

                MenuExcelDialog.jButton1.setText("" + (arrReportes.size() - i));
                Factura factura = new Factura();

                System.out.println("////////////////////// ---" + (i + 1) + "--- /////////////////////////");
                System.out.println("///////////////////// " + arrReportes.get(i) + " ///////////////////////");
                System.out.println("//////////////////////////////////////////////////////////////////////");

                Factura selectFacturaPorFolio = selectFacturaPorFolio(arrReportes.get(i).replace(".0", ""));
                String folioPre = selectFacturaPorFolio.getFolio();

                System.out.println("folioPre " + folioPre);

                if (folioPre == null) {
                    int cont = 0;
                    boolean boolPre = false;
                    try {
                        String ruta = "http://enteldte.facturanet.cl/documento/buscar/index.php";
                        driver.get(ruta);

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        String fecha2 = dtf.format(now);

                        String[] split = fecha2.split("-");
                        String fecha1 = split[0] + "-" + split[1] + "-" + (Integer.valueOf(split[2]) - 5);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mantenedor_form_M_documento_tido_id")));

                        Select select = new Select(driver.findElement(By.id("mantenedor_form_M_documento_tido_id")));
                        select.selectByIndex(4);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).sendKeys(fecha1);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).sendKeys(fecha2);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__desde\"]")).clear();

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__hasta\"]")).clear();

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).sendKeys(arrReportes.get(i).replace(".0", ""));

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__hasta\"]")).clear();

                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"div_btn_2\"]/span/button")));
                        WebElement element = driver.findElement(By.xpath("//*[@id=\"div_btn_2\"]/span/button"));
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].scrollIntoView(true);", element);
                        element.click();

                        String text = "";

                        while (!text.equals(arrReportes.get(i).replace(".0", "")) && cont < 20) {
                            try {
                                text = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell2\"]/div")).getText();
                            } catch (Exception ex) {

                            }
                            System.out.println("cont " + cont);
                            Thread.sleep(250);
                            cont++;
                        }
                    } catch (Exception ex) {
                        boolPre = true;
                    }

                    if (cont != 20 && boolPre == false) {
                        String attribute = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell13\"]/div/a[1]")).getAttribute("href");
                        System.out.println("attribute " + attribute);

                        driver.get(attribute);

                        String text1 = driver.findElement(By.tagName("body")).getText();
                        text1 = text1.replace("This XML file does not appear to have any style information associated with it. The document tree is shown below.", "").trim();
                        text1 = text1.replace("&", "Y");

                        Document convertStringToDocument = convertStringToDocument(text1);

                        if (convertStringToDocument != null) {

                            String[] split1 = attribute.split("/");
                            try ( FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "\\XMLs\\" + split1[split1.length - 1])) {
                                writeXml(convertStringToDocument, output);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (TransformerException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            convertStringToDocument.getDocumentElement().normalize();

                            NodeList nList = null;
                            folio = leerIdDoc(nList, factura, convertStringToDocument, folio);
                            leerReceptor(nList, factura, convertStringToDocument);
                            leerTotales(nList, factura, convertStringToDocument);
                            leerReferencia(nList, factura, convertStringToDocument);

                            insertOrdenCompra = false;
                            selectOrdenCompra = null;
                            boolOrigen = false;
                            int caso = 0;
                            buscaGDT = "";
                            try {
                                if (factura.getTipoDocuemnto().equals("52")) {
                                    factura.setOrigen("Local");
                                    boolOrigen = true;
                                    caso = 1;
                                }
                                if (factura.getTipoDocuemnto().equals("GDT")) {
                                    factura.setOrigen("Fabrica");
                                    boolOrigen = true;
                                    caso = 2;
                                }
                            } catch (Exception ex) {
                                /*
                                contError++;
                                ErrorExito errorExito = new ErrorExito();
                                errorExito.setFolio(arrReportes.get(i).replace(".0", ""));
                                errorExito.setDescripcion("no es 52/GDT");
                                errorExito.setEstado(false);
                                arrFoliosError.add(errorExito);
                                 */
                                ///// TODOS MENOS GDT /////
                                factura.setOrigen("Local");
                                factura.setTipoDocuemnto("52");
                                boolOrigen = true;
                                caso = 1;
                            }

                            ///// SI ES LOCAL O FABRICA /////
                            if (boolOrigen) {

                                ///// REGISTRA VENDEDOR /////
                                buscaPareaVendedor(factura);

                                ///// REGISTRA FECHA DE CARGA /////
                                DateTimeFormatter formatterx = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                String formatx = LocalDate.now().format(formatterx);

                                if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
                                    factura.setVendedor2(convertir[1].get(i));
                                }

                                ///// REGISTRA FACTURA /////
                                int insertFactura = registraFactura(factura);
                                System.out.println("-------------> " + insertFactura);

                                ///// REGISTRA = 0, PK = 1, NO REGISTRA = 2 /////
                                switch (insertFactura) {
                                    case 0:
                                        //// SI ES FABRICA ////
                                        if (caso == 2) {
                                            //// DESCARGA  Y REGISTRA OC ////
                                            MenuExcelDialog.jButton1.setText("Descargando OC...");
                                            descargaOC(factura, nList, folio);
                                        }

                                        //// REGISTRA DETALLE DEVUELVE PAREO MANUAL ////
                                        ArrayList<PareoManual> arrPareoManual = leerDetalleFactura(nList, convertStringToDocument, folio, caso);

                                        //// SI HAY PAREO MANUAL /////
                                        if (!arrPareoManual.isEmpty()) {
                                            System.out.println("!arrPareoManual.isEmpty()");

                                            ArrayList<ProductoOC> productoOC = productoOC(buscaGDT);

                                            //// SI PAREO ES UNO A UNO O NO ////
                                            if (arrPareoManual.size() == 1 && productoOC.size() == 1) {

                                                //// PROCEDIMIENTO PAREO UNO UNO ////
                                                pareoUnoUno(arrPareoManual, productoOC);
                                            } else {
                                                //// CREA VENTANA PAREO MANUAL ////
                                                pareoManual(arrPareoManual, productoOC);
                                            }
                                        }
                                        break;
                                    case 1:
                                        ErrorExito errorExito = new ErrorExito();
                                        errorExito.setFolio(arrReportes.get(i).replace(".0", ""));
                                        errorExito.setDescripcion("Ingresada");
                                        errorExito.setEstado(true);
                                        arrErrorExito.add(errorExito);
                                        break;
                                    default:
                                        contError++;
                                        ErrorExito errorExito1 = new ErrorExito();
                                        errorExito1.setFolio(arrReportes.get(i));
                                        errorExito1.setDescripcion("INSERT factura (DISTINTO A PK)");
                                        errorExito1.setEstado(false);
                                        arrErrorExito.add(errorExito1);
                                        break;
                                }

                                System.out.println("contError " + contError);

                                if (contError > 0) {
                                    try {
                                        eliminarProducto(folio);
                                        eliminarFactura(folio);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                System.out.println("////////////////////////////////////////////////////////");
                            }
                            MenuExcelDialog.jButton1.setText("Leer Excel Facturas");
                            MenuExcelDialog.jButton4.setText("Leer Excel con Origen");
                            MenuExcelDialog.jButton6.setText("Leer Excel N.Credito");
                        } else {
                            ErrorExito errorExito = new ErrorExito();
                            errorExito.setFolio(arrReportes.get(i).replace(".0", ""));
                            errorExito.setDescripcion("Error al leer XML");
                            errorExito.setEstado(false);
                            arrErrorExito.add(errorExito);
                        }
                    } else {
                        ErrorExito errorExito = new ErrorExito();
                        errorExito.setFolio(arrReportes.get(i).replace(".0", ""));
                        errorExito.setDescripcion("No se logro descargar");
                        errorExito.setEstado(false);
                        arrErrorExito.add(errorExito);
                    }
                } else {
                    ErrorExito errorExito = new ErrorExito();
                    errorExito.setFolio(arrReportes.get(i).replace(".0", ""));
                    errorExito.setDescripcion("Ya Ingresada");
                    errorExito.setEstado(true);
                    arrErrorExito.add(errorExito);
                }
            }
            driver.quit();
            //</editor-fold>
        } else {
            //<editor-fold defaultstate="collapsed" desc="Acoplar ELSE">
            System.out.println("arrReportes2.size().get(0) " + arrReportes2.size());
            for (int i = 0; i < arrReportes2.size(); i++) {
                contError = 0;
                String folio = null;

                MenuExcelDialog.jButton4.setText("" + (arrReportes2.size() - i));
                Factura factura = new Factura();

                System.out.println("////////////////////// ---" + (i + 1) + "--- /////////////////////////");
                System.out.println("///////////////////// " + arrReportes2.get(i).get(0) + " ///////////////////////");
                System.out.println("//////////////////////////////////////////////////////////////////////");

                Factura selectFacturaPorFolio = selectFacturaPorFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                String folioPre = selectFacturaPorFolio.getFolio();

                System.out.println("folioPre " + folioPre);

                if (folioPre == null) {
                    int cont = 0;
                    boolean boolPre = false;
                    try {
                        String ruta = "http://enteldte.facturanet.cl/documento/buscar/index.php";
                        driver.get(ruta);

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        String fecha2 = dtf.format(now);

                        String[] split = fecha2.split("-");
                        String fecha1 = split[0] + "-" + split[1] + "-" + (Integer.valueOf(split[2]) - 5);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mantenedor_form_M_documento_tido_id")));

                        Select select = new Select(driver.findElement(By.id("mantenedor_form_M_documento_tido_id")));
                        select.selectByIndex(4);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).sendKeys(fecha1);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).sendKeys(fecha2);

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__desde\"]")).clear();

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__hasta\"]")).clear();

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).clear();
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).sendKeys(arrReportes2.get(i).get(0).replace(".0", ""));

                        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__hasta\"]")));
                        driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__hasta\"]")).clear();

                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"div_btn_2\"]/span/button")));
                        WebElement element = driver.findElement(By.xpath("//*[@id=\"div_btn_2\"]/span/button"));
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].scrollIntoView(true);", element);
                        element.click();

                        String text = "";

                        while (!text.equals(arrReportes2.get(i).get(0).replace(".0", "")) && cont < 20) {
                            try {
                                text = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell2\"]/div")).getText();
                            } catch (Exception ex) {

                            }
                            System.out.println("cont " + cont);
                            Thread.sleep(250);
                            cont++;
                        }
                    } catch (Exception ex) {
                        boolPre = true;
                    }

                    if (cont != 20 && boolPre == false) {
                        String attribute = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell13\"]/div/a[1]")).getAttribute("href");
                        System.out.println("attribute " + attribute);

                        driver.get(attribute);

                        String text1 = driver.findElement(By.tagName("body")).getText();
                        text1 = text1.replace("This XML file does not appear to have any style information associated with it. The document tree is shown below.", "").trim();
                        text1 = text1.replace("&", "Y");

                        Document convertStringToDocument = convertStringToDocument(text1);

                        if (convertStringToDocument != null) {

                            String[] split1 = attribute.split("/");
                            try ( FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "\\XMLs\\" + split1[split1.length - 1])) {
                                writeXml(convertStringToDocument, output);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (TransformerException ex) {
                                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            convertStringToDocument.getDocumentElement().normalize();

                            NodeList nList = null;
                            folio = leerIdDoc(nList, factura, convertStringToDocument, folio);
                            leerReceptor(nList, factura, convertStringToDocument);
                            leerTotales(nList, factura, convertStringToDocument);
                            leerReferencia(nList, factura, convertStringToDocument);

                            insertOrdenCompra = false;
                            selectOrdenCompra = null;
                            boolOrigen = false;
                            int caso = 0;
                            String get = arrReportes2.get(i).get(1);
                            Double valueOf = Double.valueOf(get);
                            String format = String.format("%.0f", valueOf);
                            buscaGDT = format;

                            try {
//                                if (factura.getTipoDocuemnto().equals("GDT")) {
                                factura.setOrigen("Fabrica");
                                factura.setTipoDocuemnto("GDT");
                                boolOrigen = true;
                                caso = 2;
//                                }
                            } catch (Exception ex) {
                                contError++;
                                ErrorExito errorExito = new ErrorExito();
                                errorExito.setFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                                errorExito.setDescripcion("no es 52/GDT");
                                errorExito.setEstado(false);
                                arrErrorExito.add(errorExito);
                            }

                            ///// SI ES LOCAL O FABRICA /////
                            if (boolOrigen) {

                                ///// REGISTRA VENDEDOR /////
                                buscaPareaVendedor(factura);

                                ///// REGISTRA FECHA DE CARGA /////
                                DateTimeFormatter formatterx = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                String formatx = LocalDate.now().format(formatterx);

                                ///// REGISTRA FACTURA /////
                                int insertFactura = registraFactura(factura);
                                System.out.println("-------------> " + insertFactura);

                                ///// REGISTRA = 0, PK = 1, NO REGISTRA = 2 /////
                                switch (insertFactura) {
                                    case 0:
                                        //// SI ES FABRICA ////
                                        if (caso == 2) {
                                            //// DESCARGA  Y REGISTRA OC ////
                                            MenuExcelDialog.jButton4.setText("Descargando OC...");
                                            descargaOCSAF2(arrReportes2.get(i).get(0).replace(".0", ""), format);
                                        }

                                        //// REGISTRA DETALLE DEVUELVE PAREO MANUAL ////
                                        ArrayList<PareoManual> arrPareoManual = leerDetalleFactura(nList, convertStringToDocument, folio, caso);

                                        //// SI HAY PAREO MANUAL /////
                                        if (!arrPareoManual.isEmpty()) {
                                            System.out.println("!arrPareoManual.isEmpty()");

                                            ArrayList<ProductoOC> productoOC = productoOC(buscaGDT);

                                            //// SI PAREO ES UNO A UNO O NO ////
                                            if (arrPareoManual.size() == 1 && productoOC.size() == 1) {

                                                //// PROCEDIMIENTO PAREO UNO UNO ////
                                                pareoUnoUno(arrPareoManual, productoOC);
                                            } else {
                                                //// CREA VENTANA PAREO MANUAL ////
                                                pareoManual(arrPareoManual, productoOC);
                                            }
                                        }
                                        break;
                                    case 1:
                                        ErrorExito errorExito = new ErrorExito();
                                        errorExito.setFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                                        errorExito.setDescripcion("Ingresada");
                                        errorExito.setEstado(true);
                                        arrErrorExito.add(errorExito);
                                        break;
                                    default:
                                        contError++;
                                        ErrorExito errorExito1 = new ErrorExito();
                                        errorExito1.setFolio(arrReportes2.get(i).get(0));
                                        errorExito1.setDescripcion("INSERT factura (DISTINTO A PK)");
                                        errorExito1.setEstado(false);
                                        arrErrorExito.add(errorExito1);
                                        break;
                                }

                                System.out.println("contError " + contError);

                                if (contError > 0) {
                                    try {
                                        eliminarProducto(folio);
                                        eliminarFactura(folio);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                System.out.println("////////////////////////////////////////////////////////");
                            }
                            MenuExcelDialog.jButton1.setText("Leer Excel Facturas");
                            MenuExcelDialog.jButton4.setText("Leer Excel con Origen");
                            MenuExcelDialog.jButton6.setText("Leer Excel N.Credito");
                        } else {
                            ErrorExito errorExito = new ErrorExito();
                            errorExito.setFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                            errorExito.setDescripcion("Error al leer XML");
                            errorExito.setEstado(false);
                            arrErrorExito.add(errorExito);
                        }
                    } else {
                        ErrorExito errorExito = new ErrorExito();
                        errorExito.setFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                        errorExito.setDescripcion("No se logro descargar");
                        errorExito.setEstado(false);
                        arrErrorExito.add(errorExito);
                    }
                } else {
                    ErrorExito errorExito = new ErrorExito();
                    errorExito.setFolio(arrReportes2.get(i).get(0).replace(".0", ""));
                    errorExito.setDescripcion("Ya Ingresada");
                    errorExito.setEstado(true);
                    arrErrorExito.add(errorExito);
                }
            }
            driver.quit();
            //</editor-fold>
        }
    }

    public static void descargaOCSAF2(String folio, String folioReferencia) throws IOException, SQLException, InterruptedException {
        selectOrdenCompra = selectOrdenCompra(buscaGDT);
        System.out.println("selectOrdenCompra " + selectOrdenCompra);

        if (selectOrdenCompra == null) {

            boolean buscaGDTSAF = buscaGDTSAF(folioReferencia);
            System.out.println("buscaGDTSAF " + buscaGDTSAF);

            if (buscaGDTSAF == true) {
                OrdenCompra ordenCompra = new OrdenCompra();
                String numeroOC = "";
                String rut = "";
                String fechaEmision = "";

                System.out.println("1");
                String fileCarpeta = System.getProperty("user.dir") + "\\OcPDF";
                System.out.println("1");
                File file = new File(fileCarpeta + "\\OrdenCompra.pdf");

                String text = "";
                PdfReader reader = new PdfReader(file.getPath());
                int numberOfPages = reader.getNumberOfPages();
                System.out.println(numberOfPages);
                for (int i = 1; i < numberOfPages + 1; i++) {
                    text += PdfTextExtractor.getTextFromPage(reader, i);
                }
                reader.close();

                String[] split = text.split("\n");

                numeroOC = split[1].trim();
                ordenCompra.setNumeroOC(numeroOC);

                for (int i = 0; i < split.length; i++) {
                    String name = split[i];

                    if (name.contains("R.U.T.")) {
                        int indexOf = name.indexOf("(FAX:)");
                        rut = name.substring(6, indexOf).trim();
                        ordenCompra.setProveedor(rut);
                    }
                    if (name.contains("FECHA GENERACION")) {
                        fechaEmision = split[i + 1].trim();
                        ordenCompra.setFecha(fechaEmision);
                    }
                }

                String a = ordenCompra.getNumeroOC();
                String b = ordenCompra.getProveedor();
                String c = ordenCompra.getFecha();

                System.out.println("a " + a);
                System.out.println("b " + b);
                System.out.println("c " + c);

                try {
                    insertOrdenCompra = insertOrdenCompra(ordenCompra);
                    System.out.println("insertOrdenCompra " + insertOrdenCompra);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (insertOrdenCompra) {
                    File filtxt = new File(fileCarpeta + "\\ExtractTable.txt");

                    if (filtxt.exists()) {
                        filtxt.delete();
                    }

                    while (!filtxt.exists()) {
                        creaTXT(fileCarpeta);
                        filtxt = new File(fileCarpeta + "\\ExtractTable.txt");
                        Thread.sleep(1000);
                    }

                    Scanner obj = new Scanner(filtxt);

                    boolean fletex = false;
                    double precioFinalx = 0.0;
                    double sumaCantidadx = 0.0;
                    String st = "";
                    int num = 0;
                    while (obj.hasNextLine()) {
                        st = obj.nextLine();
                        System.out.println("st -> " + st);
                        if (num != 0) {
                            String[] split2 = st.split("@");

                            int length = split2.length;

                            if (length != 8) {
                                do {
                                    st = st + obj.nextLine();
                                    split2 = st.split("@");
                                    length = split2.length;

                                } while (length != 8);
                            }

                            split2 = st.split("@");

                            String cantidad = split2[0].replaceFirst("" + num, "").trim();
                            String codigo = split2[2].trim();
                            String precioFinal = split2[6].trim();

                            if (codigo.equals("FLETE")) {
                                fletex = true;
                                precioFinalx = Double.valueOf(precioFinal.replace(".", "").replace(",", "."));
                            } else {
                                sumaCantidadx = sumaCantidadx + Double.valueOf(cantidad.replace(".", "").replace(",", "."));
                            }
                        }
                        num++;
                    }

                    Scanner obj1 = new Scanner(filtxt);

                    String st1 = "";
                    int num1 = 0;
                    while (obj1.hasNextLine()) {
                        st1 = obj1.nextLine();
                        System.out.println("st -> " + st);
                        if (num1 != 0) {
                            try {
                                ProductoOC productoOC = new ProductoOC();

                                String[] split2 = st1.split("@");
                                int length = split2.length;
                                System.out.println("length " + length);

                                if (length != 8) {
                                    do {
                                        st1 = st1 + obj1.nextLine();
                                        split2 = st1.split("@");
                                        length = split2.length;

                                    } while (length != 8);
                                }

                                split2 = st1.split("@");

                                for (int e = 0; e < 7; e++) {
                                    String nameX = split2[e];
                                    if (e == 0) {
                                        nameX = nameX.replaceFirst("" + num1, "").trim();
                                    } else {
                                        nameX = nameX.trim();
                                    }
                                    if (e == 0) {
                                        productoOC.setCantidad(nameX.replace(".", "").replace(",", "."));
                                    }
                                    if (e == 1) {
                                        productoOC.setUnidad(nameX);
                                    }
                                    if (e == 2) {
                                        productoOC.setCodigo(nameX);
                                    }
                                    if (e == 3) {
                                        productoOC.setDescripcion(nameX);
                                    }
                                    if (e == 5) {
                                        productoOC.setCostoUnitario(nameX.replace(".", "").replace(",", "."));
                                    }
                                    if (e == 6) {
                                        productoOC.setPrecioFinal(nameX.replace(".", "").replace(",", "."));
                                    }
                                }

                                productoOC.setNumeroOC(numeroOC);

                                if (fletex) {
                                    productoOC.setValorFlete("" + (precioFinalx / sumaCantidadx));
                                }

                                String cantidad1 = productoOC.getCantidad();
                                String codigo = productoOC.getCodigo();
                                String costoUnitario1 = productoOC.getCostoUnitario();
                                String descripcion = productoOC.getDescripcion();
                                String numeroOC1 = productoOC.getNumeroOC();
                                String precioFinal1 = productoOC.getPrecioFinal();
                                String unidad = productoOC.getUnidad();
                                String valorFlete = productoOC.getValorFlete();

                                System.out.println("cantidad " + cantidad1);
                                System.out.println("codigo " + codigo);
                                System.out.println("costoUnitario " + costoUnitario1);
                                System.out.println("descripcion " + descripcion);
                                System.out.println("numeroOC " + numeroOC1);
                                System.out.println("precioFinal " + precioFinal1);
                                System.out.println("unidad " + unidad);
                                System.out.println("valorFlete " + valorFlete);

                                insertProductoOC(productoOC);
                                System.out.println("-----------------------------------------");
                            } catch (Exception ex) {
                                System.out.println("ex ----> " + ex);
                            }
                        }
                        num1++;
                    }
                }
            } else {
                contError++;
                boolOrigen = false;
                ErrorExito errorExito = new ErrorExito();
                errorExito.setFolio(folio);
                errorExito.setDescripcion("OC no encontrada, OcCliente: " + folioReferencia);
                errorExito.setEstado(false);
                arrErrorExito.add(errorExito);
            }
        }
    }

    public static void creaTXT(String fileCarpeta) throws IOException {
        try {
            //Load a sample PDF document
            System.out.println(fileCarpeta + "\\OrdenCompra.pdf");
            PdfDocument pdf = new PdfDocument(fileCarpeta + "\\OrdenCompra.pdf");

            //Create a StringBuilder instance
            StringBuilder builder = new StringBuilder();
            //Create a PdfTableExtractor instance
            PdfTableExtractor extractor = new PdfTableExtractor(pdf);

            //Loop through the pages in the PDF
            for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
                //Extract tables from the current page into a PdfTable array
                PdfTable[] tableLists = extractor.extractTable(pageIndex);

                //If any tables are found
                if (tableLists != null && tableLists.length > 0) {
                    //Loop through the tables in the array
                    for (PdfTable table : tableLists) {
                        //Loop through the rows in the current table
                        for (int i = 0; i < table.getRowCount(); i++) {
                            //Loop through the columns in the current table
                            for (int j = 0; j < table.getColumnCount(); j++) {
                                //Extract data from the current table cell and append to the StringBuilder 
                                String text = table.getText(i, j);
                                builder.append(text + " @ ");
                            }
                            builder.append("\r\n");
                        }
                    }
                }
            }

            //Write data into a .txt document
            FileWriter fw = new FileWriter(fileCarpeta + "\\ExtractTable.txt");
            fw.write(builder.toString());
            fw.flush();
            fw.close();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            System.out.println("ExtractTable");
        }
    }

    public static boolean buscaGDTSAF(String folioReferencia) {
        try {
            File fileCarpeta = new File(System.getProperty("user.dir") + "\\OcPDF");

            File file = new File(fileCarpeta + "\\OrdenCompra.pdf");
            if (file.exists()) {
                file.delete();
            }

            if (!fileCarpeta.exists()) {
                new File(System.getProperty("user.dir") + "\\Facturas").mkdir();
            }
            Map<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("plugins.always_open_pdf_externally", true);
            chromePrefs.put("safebrowsing.enabled", true);
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\OcPDF\\");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
            options.addArguments("--headless=new");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--safebrowsing-disable-download-protection");
            options.addArguments("--safebrowsing-disable-extension-blacklist");
            options.setExperimentalOption("prefs", chromePrefs);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 10);

            String baseURL = "http://192.168.5.215/saf2/";
            String rut = "RROBOT";
            String password = "T55337";

            driver.get(baseURL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"objInpText_strUsuario\"]")));
            driver.findElement(By.xpath("//*[@id=\"objInpText_strUsuario\"]")).sendKeys(rut);
            driver.findElement(By.xpath("//*[@id=\"objInpText_strClave\"]")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"objButton_loginUsuario\"]")).click();

            driver.get("http://192.168.5.215/saf2/Reportes/Previsualizar.aspx?numeroDocumento=" + folioReferencia + "&tipoDocumento=oc&origen=monitorGeneradas");

            File filex = new File(fileCarpeta + "\\OrdenCompra.pdf");
            int cont = 0;
            while (!filex.exists() && cont < 20) {
                filex = new File(fileCarpeta + "\\OrdenCompra.pdf");
                Thread.sleep(250);
                cont++;
            }

            driver.quit();

            if (cont == 20) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static void pareoManual(ArrayList<PareoManual> arrPareoManual, ArrayList<ProductoOC> productoOC) throws SQLException, IOException {
        System.out.println("!Empty");
        VentanaPareo vp = new VentanaPareo(Principal.newJFrame, true);
        vp.jPanel2.setLayout(new BoxLayout(vp.jPanel2, BoxLayout.Y_AXIS));

        ArrayList<ProductoOC> productoOCEmpty = productoOC(buscaGDT);

        for (int j = 0; j < arrPareoManual.size(); j++) {
            PareoManual pareoManual = arrPareoManual.get(j);

            JPanel jPanel1 = new javax.swing.JPanel();
            JLabel jLabel1 = new javax.swing.JLabel();
            JLabel jLabel2 = new javax.swing.JLabel();
            JLabel jLabel3 = new javax.swing.JLabel();
            JLabel jLabel4 = new javax.swing.JLabel();
            JComboBox jComboBox1 = new javax.swing.JComboBox<>();
            JComboBox jComboBox2 = new javax.swing.JComboBox<>();

            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jLabel1.setText(pareoManual.getDescripcion());
            jLabel3.setText(pareoManual.getCodigo());
            jLabel2.setText(productoOCEmpty.get(0).getDescripcion());
            jLabel4.setText("" + j);

            jComboBox1.removeAll();
            jComboBox1.addItem("GENERICO");
            for (int k = 0; k < productoOCEmpty.size(); k++) {
                jComboBox1.addItem(productoOCEmpty.get(k).getCodigo());
            }

            jComboBox2.removeAll();
            jComboBox2.addItem("DESCRIPCION GENERICO");
            for (int k = 0; k < productoOCEmpty.size(); k++) {
                jComboBox2.addItem(productoOCEmpty.get(k).getDescripcion());
            }

            jComboBox1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = jComboBox1.getSelectedIndex();
                    jComboBox2.setSelectedIndex(selectedIndex);
                }
            });

            jComboBox2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = jComboBox2.getSelectedIndex();
                    jComboBox1.setSelectedIndex(selectedIndex);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, 0, 63, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1.add(jLabel4);
            jLabel4.setVisible(false);

            vp.jPanel2.add(jPanel1);
        }
        vp.setPreferredSize(new Dimension(500, 101 + (64 * arrPareoManual.size())));
        vp.setSize(new Dimension(500, 101 + (64 * arrPareoManual.size())));

        vp.setLocationRelativeTo(Principal.newJFrame);
        vp.setVisible(true);
    }

    public static void pareoUnoUno(ArrayList<PareoManual> arrPareoManual, ArrayList<ProductoOC> productoOC) throws IOException, SQLException {
        System.out.println("arrPareoManual.size() == 1");

        PareoManual get = arrPareoManual.get(0);
        String codigox = get.getCodigo();
        Producto producto = arrProducto.get(0);
        String codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        String unidad = producto.getUnidad();
        String precioUnitario = producto.getPrecioUnitario();
        String cantidad = producto.getCantidad();
        String precioTotal = producto.getPrecioTotal();
        String foliox = producto.getFolio();

        System.out.println("codigo " + codigo);
        System.out.println("descripcion " + descripcion);
        System.out.println("unidad " + unidad);
        System.out.println("precioUnitario " + precioUnitario);
        System.out.println("cantidad " + cantidad);
        System.out.println("precioTotal " + precioTotal);
        System.out.println("folio " + foliox);
        System.out.println("codigox " + codigox);

        System.out.println("Aquiiiiiii 2");

        ProductoOC productoOCx = productoOC.get(0);

        System.out.println("productoOC != null " + productoOCx != null);
        if (productoOCx != null) {
            System.out.println("setCostoFinal " + productoOCx.getCostoUnitario());
            producto.setCostoFinal(productoOCx.getCostoUnitario());

            String textContent = productoOCx.getCostoUnitario();
            Double costoUnitario = Double.valueOf(textContent);

            System.out.println("setCostoUnitario PRE " + costoUnitario);
            costoUnitario = consultaRebate(buscaGDT, costoUnitario);
            System.out.println("setCostoUnitario POST " + costoUnitario);

            String valorFlete = productoOCx.getValorFlete();
            System.out.println("valorFlete " + valorFlete);
            if (valorFlete != null && !valorFlete.equals("null")) {
                System.out.println("NO ES NULL");
                double name1 = costoUnitario + Double.valueOf(valorFlete);
                System.out.println("COSTO UNITARIO " + name1);
                double namex = name1 * 1.025;
                producto.setCostoUnitario(String.valueOf(namex).replace(",", ""));
            } else {
                System.out.println("ES NULL");
                System.out.println("COSTO UNITARIO " + costoUnitario);
                double name1 = costoUnitario * 1.025;
                producto.setCostoUnitario(String.valueOf(name1).replace(",", ""));
            }

            producto.setNumeroOC(productoOCx.getNumeroOC());
            producto.setCodigoOC(productoOCx.getCodigo());
            producto.setCantidadOC(productoOCx.getCantidad());

            try {
                insertProducto(producto);

                ErrorExito errorExito = new ErrorExito();
                errorExito.setFolio(producto.getFolio());
                errorExito.setDescripcion("Ingresada");
                errorExito.setEstado(true);
                arrErrorExito.add(errorExito);
            } catch (IOException ex) {
                Logger.getLogger(VentanaPareo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaPareo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<PareoManual> leerDetalleFactura(NodeList nList, Document convertStringToDocument, String folio, int caso) throws SQLException, IOException {
        nList = convertStringToDocument.getElementsByTagName("Detalle");

        int contadorExito = 0;
        ArrayList<PareoManual> arrPareoManual = new ArrayList<>();
        arrProducto = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Producto producto = new Producto();
                Element eElement = (Element) node;
                System.out.println("MntNeto : " + eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent());
                String codigox = eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent();

                System.out.println("NmbItem : " + eElement.getElementsByTagName("NmbItem").item(0).getTextContent());
                String descripcion = eElement.getElementsByTagName("NmbItem").item(0).getTextContent().replace("'", "");

                if (eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent().contains("V.E.")) {
                    producto.setVentaEmpresa("1");
                } else {
                    producto.setVentaEmpresa("0");
                }

                producto.setCodigo(eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent().replace("V.E.", ""));

                System.out.println("NmbItem : " + eElement.getElementsByTagName("NmbItem").item(0).getTextContent());
                producto.setDescripcion(eElement.getElementsByTagName("NmbItem").item(0).getTextContent().replace("'", ""));

                System.out.println("UnmdRef : " + eElement.getElementsByTagName("UnmdRef").item(0).getTextContent());
                producto.setUnidad(eElement.getElementsByTagName("UnmdRef").item(0).getTextContent());

                boolean bool = false;
                System.out.println("PrcRef : " + eElement.getElementsByTagName("PrcRef").item(0).getTextContent());
                if (codigox.contains("FLETE") || descripcion.contains("FLETE")) {
                    producto.setPrecioUnitario(eElement.getElementsByTagName("MontoItem").item(0).getTextContent());
                    bool = true;
                } else {
                    producto.setPrecioUnitario(eElement.getElementsByTagName("PrcRef").item(0).getTextContent());
                }

                System.out.println("QtyItem : " + eElement.getElementsByTagName("QtyItem").item(0).getTextContent());
                producto.setCantidad(eElement.getElementsByTagName("QtyItem").item(0).getTextContent());

                System.out.println("MontoItem : " + eElement.getElementsByTagName("MontoItem").item(0).getTextContent());
                producto.setPrecioTotal(eElement.getElementsByTagName("MontoItem").item(0).getTextContent());

                producto.setFolio(folio);

                System.out.println("CASO: " + caso);

                //// SI ES FABRICA  O LOCAL ////
                if (caso == 2) {

                    selectOrdenCompra = selectOrdenCompra(buscaGDT);

                    if (selectOrdenCompra != null) {
                        if (bool) {
                            ArrayList<ProductoOC> productoOC = productoOC(buscaGDT);
                            producto.setCostoFinal("0");
                            producto.setCostoUnitario("0");
                            producto.setNumeroOC(productoOC.get(0).getNumeroOC());
                            producto.setCodigoOC("FLETE");

                            insertProducto(producto);

                            contadorExito++;
                        } else {
                            System.out.println("Aquiiiiiii 1");
                            String codigo = producto.getCodigo();
                            ProductoOC productoOC = productoOCPorCodigoOC(codigo, buscaGDT);
                            System.out.println("productoOC != null " + productoOC != null);

                            if (productoOC != null) {
                                System.out.println("DENTRO productoOC != null");
                                System.out.println("productoOC.getCostoUnitario() " + productoOC.getCostoUnitario());

                                producto.setCostoFinal(productoOC.getCostoUnitario());

                                String costoUnitarioString = productoOC.getCostoUnitario();
                                Double costoUnitario = Double.valueOf(costoUnitarioString);

                                System.out.println("setCostoUnitario PRE " + costoUnitario);
                                costoUnitario = consultaRebate(buscaGDT, costoUnitario);
                                System.out.println("setCostoUnitario POST " + costoUnitario);

                                String valorFlete = productoOC.getValorFlete();
                                System.out.println("valorFlete " + valorFlete);

                                if (valorFlete != null && !valorFlete.equals("null")) {
                                    System.out.println("NO ES NULL");
                                    double name = costoUnitario + Double.valueOf(valorFlete);
                                    System.out.println("COSTO UNITARIO " + name);
                                    double namex = name * 1.025;
                                    producto.setCostoUnitario(String.valueOf(namex).replace(",", ""));
                                } else {
                                    System.out.println("ES NULL");
                                    System.out.println("COSTO UNITARIO " + costoUnitario);
                                    double name = costoUnitario * 1.025;
                                    producto.setCostoUnitario(String.valueOf(name).replace(",", ""));
                                }

                                producto.setNumeroOC(productoOC.getNumeroOC());
                                producto.setCodigoOC(productoOC.getCodigo());
                                producto.setCantidadOC(productoOC.getCantidad());

                                insertProducto(producto);

                                contadorExito++;
                            } else {
                                System.out.println("DENTRO else productoOC != null");
                                PareoManual pareoManual = new PareoManual();
                                pareoManual.setCodigo(codigo);
                                pareoManual.setDescripcion(eElement.getElementsByTagName("NmbItem").item(0).getTextContent().replace("'", ""));

                                arrPareoManual.add(pareoManual);
                                arrProducto.add(producto);
                            }
                        }
                    }
                } else if (caso == 1) {
                    try {
                        String codigo = producto.getCodigo();
                        String ventaEmpresa = producto.getVentaEmpresa();
                        System.out.println("codigo " + codigo);
                        String selectCostoFinalCodigo = selectCostoFinalCodigoMaestra(codigo, ventaEmpresa);
                        if (selectCostoFinalCodigo != null) {
                            producto.setCostoFinal(selectCostoFinalCodigo);

                            String textContent = selectCostoFinalCodigo;
                            Double valueOf = Double.valueOf(textContent);
                            double name = valueOf * 1.02;
                            producto.setCostoUnitario(String.valueOf(name).replace(",", ""));

                            insertProducto(producto);

                            contadorExito++;
                        } else {
                            contError++;
                            ErrorExito errorExito = new ErrorExito();
                            errorExito.setFolio(folio);
                            errorExito.setDescripcion("No tiene costo de referencia: " + codigo);
                            errorExito.setEstado(false);
                            arrErrorExito.add(errorExito);
                            break;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        if (nList.getLength() == contadorExito) {
            System.out.println("EXITO");
            ErrorExito errorExito = new ErrorExito();
            errorExito.setFolio(folio);
            errorExito.setDescripcion("Ingresada");
            errorExito.setEstado(true);
            arrErrorExito.add(errorExito);
        }

        return arrPareoManual;
    }

    public static int registraFactura(Factura factura) {
        int insertFactura = 999999999;
        try {
            insertFactura = insertFactura(factura);
            System.out.println("insertFactura " + insertFactura);
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertFactura;
    }

    public static void buscaPareaVendedor(Factura factura) {
        String vendedorCliente = null;
        try {
            vendedorCliente = vendedorCliente(factura.getRutCliente());
            System.out.println("vendedorCliente " + vendedorCliente);
        } catch (IOException ex) {
//                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
//                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        factura.setVendedor(vendedorCliente);
    }

    public static void descargaOC(Factura factura, NodeList nList, String folio) throws InterruptedException, IOException, SQLException, ParserConfigurationException, SAXException {
        selectOrdenCompra = selectOrdenCompra(buscaGDT);
        System.out.println("selectOrdenCompra " + selectOrdenCompra);

        if (selectOrdenCompra == null) {

            String folioReferencia = factura.getOcCliente();
            buscaGDT = buscaGDT(folioReferencia);

            if (!buscaGDT.equals("")) {
                System.out.println(System.getProperty("user.dir") + "\\Facturas\\oc_" + buscaGDT + ".xml");
                File fXmlFile = new File(System.getProperty("user.dir") + "\\Facturas\\oc_" + buscaGDT + ".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                OrdenCompra ordenCompra = new OrdenCompra();

                nList = doc.getElementsByTagName("numero_oc");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    String numeroOC = node.getTextContent();
                    System.out.println("numero_oc : " + numeroOC);
                    ordenCompra.setNumeroOC(numeroOC);
                }

                nList = doc.getElementsByTagName("proveedor");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    String proveedor = node.getTextContent();
                    System.out.println("proveedor : " + proveedor);
                    ordenCompra.setProveedor(proveedor);
                }

                nList = doc.getElementsByTagName("fecha_generacion");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    String fecha = node.getTextContent();
                    System.out.println("fecha_generacion : " + fecha);
                    ordenCompra.setFecha(fecha);
                }

                try {
                    insertOrdenCompra = insertOrdenCompra(ordenCompra);
                    System.out.println("insertOrdenCompra " + insertOrdenCompra);
                } catch (IOException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (insertOrdenCompra) {

                    nList = doc.getElementsByTagName("detalle");

                    boolean flete = false;
                    double sumaCantidad = 0.0;
                    double precioFinal = 0.0;
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node node = nList.item(temp);
                        System.out.println("");    //Just a separator
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) node;
                            System.out.println("codigo_item_proveedor : " + eElement.getElementsByTagName("codigo_item_proveedor").item(0).getTextContent());
                            String codigox = eElement.getElementsByTagName("codigo_item_proveedor").item(0).getTextContent();

                            if (codigox.equals("FLETE")) {
                                precioFinal = Double.valueOf(eElement.getElementsByTagName("precio_final_item").item(0).getTextContent());
                                flete = true;
                            } else {
                                System.out.println("cantidad_item : " + eElement.getElementsByTagName("cantidad_item").item(0).getTextContent());
                                sumaCantidad = sumaCantidad + Double.valueOf(eElement.getElementsByTagName("cantidad_item").item(0).getTextContent().replace(".", "").replace(",", "."));
                            }
                        }
                    }

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node node = nList.item(temp);
                        System.out.println("");    //Just a separator
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            ProductoOC productoOC = new ProductoOC();

                            Element eElement = (Element) node;
                            System.out.println("codigo_item_proveedor : " + eElement.getElementsByTagName("codigo_item_proveedor").item(0).getTextContent());
                            productoOC.setCodigo(eElement.getElementsByTagName("codigo_item_proveedor").item(0).getTextContent());

                            System.out.println("descripcion_item : " + eElement.getElementsByTagName("descripcion_item").item(0).getTextContent());
                            productoOC.setDescripcion(eElement.getElementsByTagName("descripcion_item").item(0).getTextContent().replace("'", ""));

                            System.out.println("unidad_medida_item : " + eElement.getElementsByTagName("unidad_medida_item").item(0).getTextContent());
                            productoOC.setUnidad(eElement.getElementsByTagName("unidad_medida_item").item(0).getTextContent());

                            System.out.println("cantidad_item : " + eElement.getElementsByTagName("cantidad_item").item(0).getTextContent());
                            productoOC.setCantidad(eElement.getElementsByTagName("cantidad_item").item(0).getTextContent());

                            System.out.println("precio_final_item : " + eElement.getElementsByTagName("precio_final_item").item(0).getTextContent());
                            productoOC.setPrecioFinal(eElement.getElementsByTagName("precio_final_item").item(0).getTextContent());

                            System.out.println("-> " + eElement.getElementsByTagName("cantidad_item").item(0).getTextContent());
                            System.out.println("-> " + eElement.getElementsByTagName("precio_final_item").item(0).getTextContent());

                            Double cantidad = Double.valueOf(eElement.getElementsByTagName("cantidad_item").item(0).getTextContent().replace(".", "").replace(",", "."));
                            Double precioTotal = Double.valueOf(eElement.getElementsByTagName("precio_final_item").item(0).getTextContent().replace(".", "").replace(",", "."));
                            double name = precioTotal / cantidad;

                            System.out.println("costoUnitario : " + name);
                            productoOC.setCostoUnitario("" + name);

                            productoOC.setNumeroOC(buscaGDT);

                            if (flete) {
                                productoOC.setValorFlete("" + precioFinal / sumaCantidad);
                            }

                            insertProductoOC(productoOC);
                        }
                    }
                }
            } else {
                contError++;
                boolOrigen = false;
                ErrorExito errorExito = new ErrorExito();
                errorExito.setFolio(folio);
                errorExito.setDescripcion("OC no encontrada, OcCliente: " + factura.getOcCliente());
                errorExito.setEstado(false);
                arrErrorExito.add(errorExito);
            }
        }
    }

    public static String leerIdDoc(NodeList nList, Factura factura, Document convertStringToDocument, String folio) {
        nList = convertStringToDocument.getElementsByTagName("IdDoc");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("Folio : " + eElement.getElementsByTagName("Folio").item(0).getTextContent());
                folio = eElement.getElementsByTagName("Folio").item(0).getTextContent();
                factura.setFolio(eElement.getElementsByTagName("Folio").item(0).getTextContent());

                System.out.println("FchEmis : " + eElement.getElementsByTagName("FchEmis").item(0).getTextContent());
                factura.setFechaEmision(eElement.getElementsByTagName("FchEmis").item(0).getTextContent());
            }
        }
        return folio;
    }

    public static void leerReceptor(NodeList nList, Factura factura, Document convertStringToDocument) {
        nList = convertStringToDocument.getElementsByTagName("Receptor");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("RUTRecep : " + eElement.getElementsByTagName("RUTRecep").item(0).getTextContent());
                factura.setRutCliente(eElement.getElementsByTagName("RUTRecep").item(0).getTextContent());

                System.out.println("RznSocRecep : " + eElement.getElementsByTagName("RznSocRecep").item(0).getTextContent());
                factura.setRazonSocial(eElement.getElementsByTagName("RznSocRecep").item(0).getTextContent());

                System.out.println("GiroRecep : " + eElement.getElementsByTagName("GiroRecep").item(0).getTextContent());
                factura.setGiro(eElement.getElementsByTagName("GiroRecep").item(0).getTextContent());

                System.out.println("DirRecep : " + eElement.getElementsByTagName("DirRecep").item(0).getTextContent());
                factura.setDireccion(eElement.getElementsByTagName("DirRecep").item(0).getTextContent());

                System.out.println("CmnaRecep : " + eElement.getElementsByTagName("CmnaRecep").item(0).getTextContent());
                factura.setComuna(eElement.getElementsByTagName("CmnaRecep").item(0).getTextContent());

                System.out.println("CiudadRecep : " + eElement.getElementsByTagName("CiudadRecep").item(0).getTextContent());
                factura.setCiudad(eElement.getElementsByTagName("CiudadRecep").item(0).getTextContent());
            }
        }
    }

    public static void leerTotales(NodeList nList, Factura factura, Document convertStringToDocument) {
        nList = convertStringToDocument.getElementsByTagName("Totales");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("MntNeto : " + eElement.getElementsByTagName("MntNeto").item(0).getTextContent());
                factura.setMontoNeto(eElement.getElementsByTagName("MntNeto").item(0).getTextContent());

                System.out.println("TasaIVA : " + eElement.getElementsByTagName("TasaIVA").item(0).getTextContent());
                factura.setIva(eElement.getElementsByTagName("TasaIVA").item(0).getTextContent());

                System.out.println("MntTotal : " + eElement.getElementsByTagName("MntTotal").item(0).getTextContent());
                factura.setMontoTotal(eElement.getElementsByTagName("MntTotal").item(0).getTextContent());
            }
        }
    }

    public static void leerReferencia(NodeList nList, Factura factura, Document convertStringToDocument) {
        nList = convertStringToDocument.getElementsByTagName("Referencia");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("eElement.getTagName() " + eElement.getTagName());

                if (eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent().equals("GDT")) {
                    System.out.println("TpoDocRef : " + eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());
                    factura.setTipoDocuemnto(eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());

                    System.out.println("FolioRef : " + eElement.getElementsByTagName("FolioRef").item(0).getTextContent());
                    factura.setOcCliente(eElement.getElementsByTagName("FolioRef").item(0).getTextContent());

                    String fechaReferencia = factura.getFechaReferencia();
                    if (fechaReferencia == null) {
                        System.out.println("FolioRef : " + eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                        factura.setFechaReferencia(eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                    }
                } else if (eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent().equals("52")) {
                    System.out.println("TpoDocRef : " + eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());
                    factura.setTipoDocuemnto(eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());

                    System.out.println("FolioRef : " + eElement.getElementsByTagName("FolioRef").item(0).getTextContent());
                    factura.setOcCliente(eElement.getElementsByTagName("FolioRef").item(0).getTextContent());

                    String fechaReferencia = factura.getFechaReferencia();
                    if (fechaReferencia == null) {
                        System.out.println("FolioRef : " + eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                        factura.setFechaReferencia(eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                    }
                } else {
                    System.out.println("FolioRef : " + eElement.getElementsByTagName("FolioRef").item(0).getTextContent());
                    factura.setFolioReferencia(eElement.getElementsByTagName("FolioRef").item(0).getTextContent());

                    String fechaReferencia = factura.getFechaReferencia();
                    if (fechaReferencia == null) {
                        System.out.println("FolioRef : " + eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                        factura.setFechaReferencia(eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                    }
                }
            }
        }
    }

    public static double consultaRebate(String buscaGDT, double costo) throws IOException, SQLException {
        /*CONSULTA RUT OC REBALE*/
        OrdenCompra selectOrdenCompra = selectOrdenCompra(buscaGDT);

        System.out.println("proveedor " + selectOrdenCompra.getProveedor());
        String proveedor = selectOrdenCompra.getProveedor();
        ArrayList<PorcentajeProveedorRebate> selectPorcentajeXProveedorRebate = selectPorcentajeXProveedorRebateLike(proveedor);

        System.out.println("selectPorcentajeXProveedorRebate.isEmpty() " + selectPorcentajeXProveedorRebate.isEmpty());
        if (!selectPorcentajeXProveedorRebate.isEmpty()) {

            int mayor = 0;
            String rebate = "";

            for (int j = 0; j < selectPorcentajeXProveedorRebate.size(); j++) {
                PorcentajeProveedorRebate getx = selectPorcentajeXProveedorRebate.get(j);
                String año = getx.getAño();
                String porcentaje = getx.getPorcentaje();

                if (Integer.valueOf(año) > mayor) {
                    mayor = Integer.valueOf(año);
                    rebate = porcentaje;
                }
            }
            Double porcentaje = 100 - Double.valueOf(rebate);
            Double porcentajeDouble = porcentaje / 100;

            System.out.println("---------------> porcentajeDouble " + porcentajeDouble);

            costo = costo * porcentajeDouble;

            return costo;
        } else {
            return costo;
        }
    }

    public static void chromeDriverNotaDeCredito() throws InterruptedException, MalformedURLException, IOException, EncoderException, TransformerException, SQLException {
        arrErrorExito = new ArrayList<>();

        String rut = "76008058-6";
        String password = "8058";

        String baseURL = "http://enteldte.facturanet.cl/login/index.php";

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\XMLs");
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("disable-popup-blocking", true);
        prefs.put("download.extensions_to_open", "application/xml");

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--safebrowsing-disable-extension-blacklist");
        options.addArguments("--headless=new");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(baseURL);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"username\"]")));

        System.out.println("------");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(rut);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/form/div[3]/button")).click();

        System.out.println("------");

//        System.out.println("arrReportes.size() " + arrReportes3.size());
        ArrayList<String>[] convertir = null;
        if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
            convertir = convertir(arrReportes2);
            arrReportes3 = convertir[0];
        }

        for (int i = 0; i < arrReportes3.size(); i++) {
            try {
                MenuExcelDialog.jButton6.setText("" + (arrReportes3.size() - i));
                NotaCredito notaCredito = new NotaCredito();

                System.out.println("////////////////////// ---" + (i + 1) + "--- /////////////////////////");
                System.out.println("////////////////////////////////////////////////////////");

                String http1921685216documentobuscarindexphpbusc = "http://enteldte.facturanet.cl/documento/buscar/index.php";
                driver.get(http1921685216documentobuscarindexphpbusc);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime now = LocalDateTime.now();
                String fecha2 = dtf.format(now);

                String[] split = fecha2.split("-");
                String fecha1 = split[0] + "-" + split[1] + "-" + (Integer.valueOf(split[2]) - 5);

                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mantenedor_form_M_documento_tido_id")));

                Select select = new Select(driver.findElement(By.id("mantenedor_form_M_documento_tido_id")));
                select.selectByIndex(8);

                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__desde\"]")).sendKeys(fecha1);

                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_emision__hasta\"]")).sendKeys(fecha2);

                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__desde\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_fecha_recepcion__hasta\"]")).clear();

                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).clear();
                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__desde\"]")).sendKeys(arrReportes3.get(i).replace(".0", ""));

                driver.findElement(By.xpath("//*[@id=\"mantenedor_form_M_documento_docu_folio__hasta\"]")).clear();

                WebElement element = driver.findElement(By.xpath("//*[@id=\"div_btn_2\"]/span/button"));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();

                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell2\"]/div")));
                String text = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell2\"]/div")).getText();

                while (!text.equals(arrReportes3.get(i).replace(".0", ""))) {
                    try {
                        text = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell2\"]/div")).getText();
                    } catch (Exception ex) {

                    }
                }
                String attribute = driver.findElement(By.xpath("//*[@id=\"yui-dt0-bdrow0-cell13\"]/div/a[1]")).getAttribute("href");
                System.out.println("attribute " + attribute);

                driver.get(attribute);

                String text1 = driver.findElement(By.tagName("body")).getText();
                text1 = text1.replace("This XML file does not appear to have any style information associated with it. The document tree is shown below.", "").trim();

                Document convertStringToDocument = convertStringToDocument(text1);

                String[] split1 = attribute.split("/");
                try ( FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "\\XMLs\\" + split1[split1.length - 1])) {
                    writeXml(convertStringToDocument, output);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TransformerException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }

                convertStringToDocument.getDocumentElement().normalize();

                NodeList nList = convertStringToDocument.getElementsByTagName("IdDoc");
                String folio = "";

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    System.out.println("");    //Just a separator
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        //Print each employee's detail
                        Element eElement = (Element) node;
                        System.out.println("Folio : " + eElement.getElementsByTagName("Folio").item(0).getTextContent());
                        folio = eElement.getElementsByTagName("Folio").item(0).getTextContent();
                        notaCredito.setFolio(eElement.getElementsByTagName("Folio").item(0).getTextContent());

                        System.out.println("FchEmis : " + eElement.getElementsByTagName("FchEmis").item(0).getTextContent());
                        notaCredito.setFecha(eElement.getElementsByTagName("FchEmis").item(0).getTextContent());
                    }
                }

                nList = convertStringToDocument.getElementsByTagName("Receptor");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    System.out.println("");    //Just a separator
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        //Print each employee's detail
                        Element eElement = (Element) node;
                        System.out.println("RUTRecep : " + eElement.getElementsByTagName("RUTRecep").item(0).getTextContent());
                        notaCredito.setCliente(eElement.getElementsByTagName("RUTRecep").item(0).getTextContent());

                        System.out.println("RznSocRecep : " + eElement.getElementsByTagName("RznSocRecep").item(0).getTextContent());
                        notaCredito.setRazonSocial(eElement.getElementsByTagName("RznSocRecep").item(0).getTextContent());

                        System.out.println("GiroRecep : " + eElement.getElementsByTagName("GiroRecep").item(0).getTextContent());
                        notaCredito.setGiro(eElement.getElementsByTagName("GiroRecep").item(0).getTextContent());

                        System.out.println("DirRecep : " + eElement.getElementsByTagName("DirRecep").item(0).getTextContent());
                        notaCredito.setDireccion(eElement.getElementsByTagName("DirRecep").item(0).getTextContent());

                        System.out.println("CmnaRecep : " + eElement.getElementsByTagName("CmnaRecep").item(0).getTextContent());
                        notaCredito.setComuna(eElement.getElementsByTagName("CmnaRecep").item(0).getTextContent());

                        System.out.println("CiudadRecep : " + eElement.getElementsByTagName("CiudadRecep").item(0).getTextContent());
                        notaCredito.setCiudad(eElement.getElementsByTagName("CiudadRecep").item(0).getTextContent());
                    }
                }

                nList = convertStringToDocument.getElementsByTagName("Totales");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    System.out.println("");    //Just a separator
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        //Print each employee's detail
                        Element eElement = (Element) node;
                        System.out.println("MntNeto : " + eElement.getElementsByTagName("MntNeto").item(0).getTextContent());
                        notaCredito.setNeto(eElement.getElementsByTagName("MntNeto").item(0).getTextContent());

                        System.out.println("TasaIVA : " + eElement.getElementsByTagName("TasaIVA").item(0).getTextContent());
                        notaCredito.setIva(eElement.getElementsByTagName("TasaIVA").item(0).getTextContent());

                        System.out.println("MntTotal : " + eElement.getElementsByTagName("MntTotal").item(0).getTextContent());
                        notaCredito.setTotal(eElement.getElementsByTagName("MntTotal").item(0).getTextContent());
                    }
                }

                nList = convertStringToDocument.getElementsByTagName("Referencia");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    System.out.println("");    //Just a separator
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        //Print each employee's detail
                        Element eElement = (Element) node;
                        if (temp == 0) {
                            System.out.println("TpoDocRef : " + eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());
                            notaCredito.setTipoDocuemnto(eElement.getElementsByTagName("TpoDocRef").item(0).getTextContent());

                            System.out.println("FolioRef : " + eElement.getElementsByTagName("FolioRef").item(0).getTextContent());
                            notaCredito.setFolioReferencia(eElement.getElementsByTagName("FolioRef").item(0).getTextContent());

                            System.out.println("FchRef : " + eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                            notaCredito.setFechaReferencia(eElement.getElementsByTagName("FchRef").item(0).getTextContent());
                        }
                    }
                }

                nList = convertStringToDocument.getElementsByTagName("Personalizados");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node node = nList.item(temp);
                    System.out.println("");
                    String textContent = node.getTextContent();
                    System.out.println("" + textContent);
                    String[] split2 = textContent.trim().split("\n");
                    String name = split2[1];
                    notaCredito.setMotivo(name);
                }

                Factura selectFacturaPorFolio = selectFacturaPorFolio(notaCredito.getFolioReferencia());

                if (selectFacturaPorFolio.getFolio() != null) {

                    String folioFactura = selectFacturaPorFolio.getFolio();

                    if (folioFactura.equals(notaCredito.getFolioReferencia())) {
                        String vendedor = selectFacturaPorFolio.getVendedor();
                        String origen = selectFacturaPorFolio.getOrigen();

                        notaCredito.setVendedor(vendedor);
                        notaCredito.setOrigen(origen);

                        String vendedorCliente = null;
                        try {
                            vendedorCliente = vendedorCliente(notaCredito.getCliente());
                        } catch (IOException ex) {
                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        notaCredito.setVendedor(vendedorCliente);

                        if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
                            notaCredito.setVendedor2(convertir[1].get(i));
                        }

                        int insertNotaCredito = insertNotaCredito(notaCredito);

                        switch (insertNotaCredito) {
                            case 0:
                                int contadorExito = 0;
                                nList = convertStringToDocument.getElementsByTagName("Detalle");

                                for (int temp = 0; temp < nList.getLength(); temp++) {
                                    Node node = nList.item(temp);
                                    System.out.println("");    //Just a separator
                                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                                        //Print each employee's detail
                                        ProductoNotaCredito productoNotaCredito = new ProductoNotaCredito();
                                        Element eElement = (Element) node;
                                        System.out.println("VlrCodigo : " + eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent());
                                        productoNotaCredito.setCodigo(eElement.getElementsByTagName("VlrCodigo").item(0).getTextContent());

                                        System.out.println("NmbItem : " + eElement.getElementsByTagName("NmbItem").item(0).getTextContent());
                                        productoNotaCredito.setDescripcion(eElement.getElementsByTagName("NmbItem").item(0).getTextContent());

                                        System.out.println("QtyItem : " + eElement.getElementsByTagName("QtyItem").item(0).getTextContent());
                                        productoNotaCredito.setCantidad(eElement.getElementsByTagName("QtyItem").item(0).getTextContent());

                                        System.out.println("PrcItem : " + eElement.getElementsByTagName("PrcItem").item(0).getTextContent());
                                        productoNotaCredito.setNeto(eElement.getElementsByTagName("PrcItem").item(0).getTextContent());

                                        System.out.println("MontoItem : " + eElement.getElementsByTagName("MontoItem").item(0).getTextContent());
                                        productoNotaCredito.setTotal(eElement.getElementsByTagName("MontoItem").item(0).getTextContent());

                                        productoNotaCredito.setFolio(folio);

                                        insertProductoNotaCredito(productoNotaCredito);

                                        contadorExito++;
                                    }
                                }

                                System.out.println("nList.getLength() " + nList.getLength());
                                System.out.println("contadorExito " + contadorExito);
//                                System.exit(0);

                                if (nList.getLength() == contadorExito) {
                                    System.out.println("EXITO");
                                    ErrorExito errorExito = new ErrorExito();
                                    errorExito.setFolio(folio);
                                    errorExito.setDescripcion("Ingresada");
                                    errorExito.setEstado(true);
                                    arrErrorExito.add(errorExito);
                                }
                            case 1: {
                                ErrorExito errorExito = new ErrorExito();
                                errorExito.setFolio(arrReportes3.get(i).replace(".0", ""));
                                errorExito.setDescripcion("Ya Ingresada");
                                errorExito.setEstado(true);
                                arrErrorExito.add(errorExito);
                                break;
                            }
                            default: {
                                ErrorExito errorExito = new ErrorExito();
                                errorExito.setFolio(arrReportes3.get(i).replace(".0", ""));
                                errorExito.setDescripcion("INSERT Nota de Credito (DISTINTO A PK)");
                                errorExito.setEstado(false);
                                arrErrorExito.add(errorExito);
                                break;
                            }
                        }
                    } else {
                        ErrorExito errorExito = new ErrorExito();
                        errorExito.setFolio(arrReportes3.get(i).replace(".0", ""));
                        errorExito.setDescripcion("Factura de refencia no existe: " + notaCredito.getFolioReferencia());
                        errorExito.setEstado(false);
                        arrErrorExito.add(errorExito);
                    }
                } else {
                    ErrorExito errorExito = new ErrorExito();
                    errorExito.setFolio(arrReportes3.get(i).replace(".0", ""));
                    errorExito.setDescripcion("Factura de refencia no existe: " + notaCredito.getFolioReferencia());
                    errorExito.setEstado(false);
                    arrErrorExito.add(errorExito);
                }
                System.out.println("////////////////////////////////////////////////////////");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        MenuExcelDialog.jButton1.setText("Leer Excel Facturas");
        MenuExcelDialog.jButton4.setText("Leer Excel con Origen");
        MenuExcelDialog.jButton6.setText("Leer Excel N.Credito");
        driver.quit();
    }

    public static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource((Node) doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    public static Document convertStringToDocument(String xmlStr) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> arrReportes(String path) throws FileNotFoundException, IOException {
        System.out.println("path " + path);
        ArrayList<String> arrFolios = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream(new File(path));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        while (rows.hasNext()) {
            int cont = 0;
            row = (Row) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                System.out.println(cont);
                cell = (Cell) cells.next();
                switch (cont) {
                    case 0: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                arrFolios.add(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                arrFolios.add(cell.getStringCellValue());
                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                arrFolios.add(cell.getStringCellValue());
                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                arrFolios.add(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
                cont++;
            }
        }

        ExcelFileToRead.close();

        return arrFolios;
    }

    public static ArrayList<ArrayList<String>> arrReportes2(String path) throws FileNotFoundException, IOException {
        ArrayList<ArrayList<String>> arrArrFolios = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream(new File(path));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        while (rows.hasNext()) {
            ArrayList<String> arrFolio = new ArrayList<>();
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            int cont = 0;
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                switch (cont) {
                    case 0:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                arrFolio.add(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                arrFolio.add(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                arrFolio.add(cell.getStringCellValue());
                            } catch (Exception e) {
                                arrFolio.add(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 1:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                arrFolio.add(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                arrFolio.add(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                arrFolio.add(cell.getStringCellValue());
                            } catch (Exception e) {
                                arrFolio.add(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                }
                cont++;
            }
            arrArrFolios.add(arrFolio);
        }

        ExcelFileToRead.close();

        return arrArrFolios;
    }

    public static ArrayList<ActualizaCodigoPrecio> arrReportes3(String path) throws FileNotFoundException, IOException {
        System.out.println("path " + path);
        ArrayList<ActualizaCodigoPrecio> arrActualizaCodigoPrecio = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream(new File(path));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        while (rows.hasNext()) {
            ActualizaCodigoPrecio actualizaCodigoPrecio = new ActualizaCodigoPrecio();
            int cont = 0;
            row = (Row) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                System.out.println(cont);
                cell = (Cell) cells.next();
                switch (cont) {
                    case 0: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                actualizaCodigoPrecio.setCodigo(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                actualizaCodigoPrecio.setCodigo(cell.getStringCellValue());
                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                actualizaCodigoPrecio.setCodigo(cell.getStringCellValue());
                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                actualizaCodigoPrecio.setCodigo(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 1: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                actualizaCodigoPrecio.setPrecio(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                actualizaCodigoPrecio.setPrecio(cell.getStringCellValue());
                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                actualizaCodigoPrecio.setPrecio(cell.getStringCellValue());
                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                actualizaCodigoPrecio.setPrecio(String.valueOf(cell.getNumericCellValue()));
                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
                cont++;
            }
            arrActualizaCodigoPrecio.add(actualizaCodigoPrecio);
        }

        ExcelFileToRead.close();

        return arrActualizaCodigoPrecio;
    }

    public static ArrayList<Maestra> arrMaestra(String path) throws FileNotFoundException, IOException {
        ArrayList<Maestra> arrMaestra = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream(new File(path));

        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        Iterator rows = sheet.rowIterator();
        rows.next();

        while (rows.hasNext()) {
            Maestra maestra = new Maestra();
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            int cont = 0;
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                switch (cont) {
                    case 0:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setCodigoProducto(String.valueOf(cell.getNumericCellValue()).replaceAll("Ñ", "N").replaceAll("ñ", "n"));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setCodigoProducto(cell.getStringCellValue().replaceAll("Ñ", "N").replaceAll("ñ", "n"));
                            }
                        } else {
                            try {
                                maestra.setCodigoProducto(cell.getStringCellValue().replaceAll("Ñ", "N").replaceAll("ñ", "n"));
                            } catch (Exception e) {
                                maestra.setCodigoProducto(String.valueOf(cell.getNumericCellValue()).replaceAll("Ñ", "N").replaceAll("ñ", "n"));
                            }
                        }
                        break;
                    case 1:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setDescripcion(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setDescripcion(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setDescripcion(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setDescripcion(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 2:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setStock(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setStock(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setStock(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setStock(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 3:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setUnidad(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setUnidad(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setUnidad(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setUnidad(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 4:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setMedida(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setMedida(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setMedida(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setMedida(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 5:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setCostoFinalSaf(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setCostoFinalSaf(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setCostoFinalSaf(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setCostoFinalSaf(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 6:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setMargen(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setMargen(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setMargen(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setMargen(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 7:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setNeto(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setNeto(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setNeto(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setNeto(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 8:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setPrecioFinal(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setPrecioFinal(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setPrecioFinal(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setPrecioFinal(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                    case 9:
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                maestra.setFamilia(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                maestra.setFamilia(cell.getStringCellValue());
                            }
                        } else {
                            try {
                                maestra.setFamilia(cell.getStringCellValue());
                            } catch (Exception e) {
                                maestra.setFamilia(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        break;
                }
                cont++;
            }
            arrMaestra.add(maestra);
        }

        return arrMaestra;
    }

    public static void Monitor() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    if (me != null) {
                        File file1 = new File(System.getProperty("user.dir") + "\\ListadoFacturas.xlsx");
                        boolean exists = file1.exists();
                        if (ejecucion1 == 0) {
                            if (exists) {
                                MenuExcelDialog.jButton1.setEnabled(true);
                            } else {
                                MenuExcelDialog.jButton1.setEnabled(false);
                            }
                        } else {
                            MenuExcelDialog.jButton1.setEnabled(false);
                        }

                        File file4 = new File(System.getProperty("user.dir") + "\\FacturasNombre.xlsx");
                        boolean exists4 = file4.exists();
                        if (ejecucion1 == 0) {
                            if (exists4) {
                                MenuExcelDialog.jButton1.setEnabled(true);
                            } else {
                                MenuExcelDialog.jButton1.setEnabled(false);
                            }
                        } else {
                            MenuExcelDialog.jButton1.setEnabled(false);
                        }

                        File file2 = new File(System.getProperty("user.dir") + "\\ListadoFacturas2.xlsx");
                        boolean exists2 = file2.exists();
                        if (ejecucion2 == 0) {
                            if (exists2) {
                                MenuExcelDialog.jButton4.setEnabled(true);
                            } else {
                                MenuExcelDialog.jButton4.setEnabled(false);
                            }
                        } else {
                            MenuExcelDialog.jButton4.setEnabled(false);
                        }

                        File file3 = new File(System.getProperty("user.dir") + "\\ListadoNotasCredito.xlsx");
                        boolean exists3 = file3.exists();
                        if (ejecucion3 == 0) {
                            if (exists3) {
                                MenuExcelDialog.jButton6.setEnabled(true);
                            } else {
                                MenuExcelDialog.jButton6.setEnabled(false);
                            }
                        } else {
                            MenuExcelDialog.jButton6.setEnabled(false);
                        }

                        File file5 = new File(System.getProperty("user.dir") + "\\ListadoNotasCreditoNombre.xlsx");
                        boolean exists5 = file5.exists();
                        if (ejecucion3 == 0) {
                            if (exists5) {
                                MenuExcelDialog.jButton6.setEnabled(true);
                            } else {
                                MenuExcelDialog.jButton6.setEnabled(false);
                            }
                        } else {
                            MenuExcelDialog.jButton6.setEnabled(false);
                        }
                    }
                    Thread.sleep(250);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.start();
    }

    private static String formatCurrency(double value) {
        Locale chileLocale = new Locale("es", "CL");
        String currencySymbol = Currency.getInstance(chileLocale).getSymbol();
        NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);
        try {
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(0);
            nf.setGroupingUsed(true);
            String formattedValue = nf.format(value);
            return currencySymbol + " " + formattedValue;
        } catch (Exception ex) {
            return currencySymbol + " " + value;
        }
    }

    public static String buscaGDT(String folioReferencia) throws InterruptedException, IOException {
        try {
            File fileCarpeta = new File(System.getProperty("user.dir") + "\\Facturas");
            if (!fileCarpeta.exists()) {
                new File(System.getProperty("user.dir") + "\\Facturas").mkdir();
            }
            Map<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("plugins.always_open_pdf_externally", true);
            chromePrefs.put("safebrowsing.enabled", true);
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\Facturas\\");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--host-resolver-rules=MAP www.google-analytics.com 127.0.0.1");
            options.addArguments("--headless=new");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--safebrowsing-disable-download-protection");
            options.addArguments("--safebrowsing-disable-extension-blacklist");
            options.setExperimentalOption("prefs", chromePrefs);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 10);

            String baseURL = "https://asociado.chilemat.cl/";
            String rut = "17568448-4";
            String password = "qu4tfx";

            driver.get(baseURL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"txtRut\"]")));
            driver.findElement(By.xpath("//*[@id=\"txtRut\"]")).sendKeys(rut);
            driver.findElement(By.xpath("//*[@id=\"objInpText_strClave\"]")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"objButton_loginUsuario\"]")).click();

            driver.get("https://asociado.chilemat.cl/clientes/michilemat/consultarDocumentos.aspx");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/"
                    + "tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/tbody/"
                    + "tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr/td[5]/input")));

            driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/"
                    + "tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/tbody/"
                    + "tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr/td[5]/input")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/"
                    + "tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/tbody/tr/td/"
                    + "table/tbody/tr[2]/td/table/tbody/tr/td[2]/input")));

            driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/"
                    + "tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/tbody/tr/td/"
                    + "table/tbody/tr[2]/td/table/tbody/tr/td[2]/input")).sendKeys(folioReferencia);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/"
                    + "tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/"
                    + "tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/input")));

            driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/"
                    + "tbody/tr/td/contenttemplate/table[1]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/"
                    + "tbody/tr/td[3]/input")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/"
                    + "table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/table/tbody/tr/td/contenttemplate/table[2]/tbody/tr[3]/"
                    + "td/table/tbody/tr[2]/td[1]")));

            String textx = driver.findElement(By.xpath("/html/body/form/div[3]/table/tbody/tr/td/table[1]/tbody/tr/td/table[3]/tbody/tr/td[2]/"
                    + "table/tbody/tr/td/contenttemplate/table[2]/tbody/tr[3]/td/table/tbody/tr[2]/td[1]")).getText();

            System.out.println("text " + textx);

            driver.get("https://asociado.chilemat.cl/Reportes/ReportesPDF.aspx?strTipoReporte=XML&N=" + textx);

            File file = new File(System.getProperty("user.dir") + "\\Facturas\\oc_" + textx + ".xml");
            while (!file.exists()) {
                file = new File(System.getProperty("user.dir") + "\\Facturas\\oc_" + textx + ".xml");
                Thread.sleep(1000);
            }

            driver.quit();

            return textx;
        } catch (Exception ex) {
            driver.quit();
            return "";
        }
    }

    public static void insertCargarFlete() {
        Flete flete = new Flete();
        Date datoFecha = Principal.rSDateChooser3.getDatoFecha();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = "";
        try {
            today = formatter.format(datoFecha);
        } catch (Exception ex) {

        }
        flete.setFechaFa(today);
        flete.setNumeroFa(jTextField2.getText());
        flete.setVendedor(Principal.jComboBox3.getSelectedItem().toString());
        flete.setMontoFa(jTextField4.getText());
        flete.setMontoFaVendedor(jTextField5.getText());
        flete.setObservacion(jTextField6.getText());

        System.out.println(today);
        System.out.println(jTextField2.getText());
        System.out.println(Principal.jComboBox3.getSelectedItem().toString());
        System.out.println(jTextField4.getText());
        System.out.println(jTextField5.getText());
        System.out.println(jTextField6.getText());

        if (!today.equals("")
                && !jTextField2.getText().equals("")
                && !Principal.jComboBox3.getSelectedItem().toString().equals("")
                && !jTextField4.getText().equals("")
                && !jTextField5.getText().equals("")) {

            boolean insertFlete = false;
            try {
                insertFlete = fleteDAO.insertFlete(flete);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(insertFlete);

            ((DefaultTableModel) jTable4.getModel()).setNumRows(0);

            Object[] filaTabla4 = new Object[10];
            DefaultTableModel modelTabla4 = (DefaultTableModel) jTable4.getModel();

            ArrayList<Flete> selectFlete = null;
            try {
                selectFlete = fleteDAO.selectFlete(VentanaLogin.tipo, VentanaLogin.nombrex);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            Locale chileLocale = new Locale("es", "CL");
            NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

            selectFlete.stream().forEach((Flete fletex) -> {
                filaTabla4[0] = fletex.getFechaFa();
                filaTabla4[1] = fletex.getNumeroFa();
                filaTabla4[2] = fletex.getVendedor();

                String format = nf.format(Double.valueOf(fletex.getMontoFa()));
                String[] split = format.split(",");

                try {
                    filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla4[3] = "$ " + split[0];
                    }
                }

                format = nf.format(Double.valueOf(fletex.getMontoFaVendedor()));
                split = format.split(",");

                try {
                    filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla4[4] = "$ " + split[0];
                    }
                }
                filaTabla4[5] = fletex.getObservacion();
                modelTabla4.addRow(filaTabla4);
            });

            Principal.rSDateChooser3.setDatoFecha(null);
            jTextField2.setText("");
            Principal.jComboBox3.setSelectedIndex(0);
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
        } else {
            JOptionPane.showMessageDialog(Principal.newJFrame, "Alguno de los campos esta vacio.\n*Solo la observacion puede estarlo.", "Campos vacios", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            width = Math.max(width, table.getColumnModel().getColumn(column).getPreferredWidth());
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public static void filtraRecuadroDos() {
        try {
            try {
                ((DefaultTableModel) jTable5.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }

            String nombrex = VentanaLogin.nombrex;
            int tipo = VentanaLogin.tipo;

            double sumaUtilidad1 = 0;
            double sumaUtilidad2 = 0;
            double sumaNeto = 0;

            Date datoFecha = rSDateChooser6.getDatoFecha();
            Date datoFecha2 = rSDateChooser7.getDatoFecha();

            boolean selected = jCheckBox4.isSelected();
            boolean selected2 = jCheckBox3.isSelected();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(datoFecha);
            System.out.println(date);

            String date2 = simpleDateFormat.format(datoFecha2);
            System.out.println(date2);

            Locale chileLocale = new Locale("es", "CL");
            NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

            Object[] filaTabla5 = new Object[4];
            DefaultTableModel modelTabla5 = (DefaultTableModel) jTable5.getModel();

            for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
                String fecha = jTable2.getModel().getValueAt(j, 0).toString();
                String pagada = jTable2.getModel().getValueAt(j, 11).toString();

                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                Date parse = dateFormat.parse(fecha.toString());
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                fecha = dateFormat.format(parse);

                if (selected == true && selected2 == true) {
                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                        double neto = Double.valueOf(jTable2.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));
                        double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));

                        if (utilidad > 0) {
                            sumaNeto = sumaNeto + neto;
                        }
                    }
                } else if (selected == true && selected2 == false) {
                    if (pagada.trim().equals("false")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            double neto = Double.valueOf(jTable2.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));
                            double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));

                            if (utilidad > 0) {
                                sumaNeto = sumaNeto + neto;
                            }
                        }
                    }
                } else if (selected == false && selected2 == true) {
                    if (pagada.trim().equals("true")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            double neto = Double.valueOf(jTable2.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));
                            double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));

                            if (utilidad > 0) {
                                sumaNeto = sumaNeto + neto;
                            }
                        }
                    }
                }
            }

            System.out.println("sumaNeto " + sumaNeto);

            for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                String toString = jComboBox1.getItemAt(i);
                if (!toString.equals("EDUARDO VEGA") && !toString.equals("VICTOR ESPINOZA R.") && !toString.equals("CARLOS MATURANA") && !toString.equals("Todos") && !toString.equals("CHERYL BERRIOS")) {
                    double sumaUtilidadNCBono = 0;
                    double sumaUtilidadNCLocal = 0;
                    double sumaUtilidadNC = 0;
                    double sumaUtilidadLocal = 0;
                    double sumaUtilidad = 0;
                    double sumaCostoNCLocal = 0;
                    double sumaCostoNC = 0;
                    double sumaCostoLocal = 0;
                    double sumaCosto = 0;
                    double sumaFlete = 0;
                    double sumaBono = 0;

                    for (int x = 0; x < jTable4.getModel().getRowCount(); x++) {
                        String fecha = jTable4.getModel().getValueAt(x, 0).toString();
                        String[] split = fecha.split("-");
                        fecha = split[2] + split[1] + split[0];
                        String vendedor = jTable4.getModel().getValueAt(x, 2).toString();
                        double monto = Double.valueOf(jTable4.getModel().getValueAt(x, 4).toString().replace(".", "").replace(",", ".").replace("$", ""));

                        if (toString.equals(vendedor)) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                sumaFlete = sumaFlete + monto;
                            }
                        }
                    }

                    for (int j = 0; j < jTable3.getModel().getRowCount(); j++) {
                        String fecha = jTable3.getModel().getValueAt(j, 0).toString();
                        String vendedor = jTable3.getModel().getValueAt(j, 7).toString();
                        String origen = jTable3.getModel().getValueAt(j, 9).toString();
                        double costo = Double.valueOf(jTable3.getModel().getValueAt(j, 4).toString().replace("$", "").replace(".", "").replace(",", "."));
                        double utilidad = Double.valueOf(jTable3.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                        if (toString.equals(vendedor)) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                sumaUtilidadNC = sumaUtilidadNC + utilidad;
                                sumaCostoNC = sumaCostoNC + costo;

                                if (origen.equals("Local")) {
                                    sumaUtilidadNCLocal = sumaUtilidadNCLocal + utilidad;
                                    sumaCostoNCLocal = sumaCostoNCLocal + costo;
                                }
                            }
                        }
                    }

                    for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
                        String folio = jTable2.getModel().getValueAt(j, 1).toString();
                        String vendedor = jTable2.getModel().getValueAt(j, 4).toString();
                        double costo = Double.valueOf(jTable2.getModel().getValueAt(j, 5).toString().replace("$", "").replace(".", "").replace(",", "."));
                        double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));
                        String margen = jTable2.getModel().getValueAt(j, 8).toString();
                        String origen = jTable2.getModel().getValueAt(j, 9).toString();
                        String fecha = jTable2.getModel().getValueAt(j, 0).toString();
                        String pagada = jTable2.getModel().getValueAt(i, 11).toString();

                        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                        Date parse = dateFormat.parse(fecha.toString());
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        fecha = dateFormat.format(parse);

                        if (selected == true && selected2 == true) {
                            if (toString.equals(vendedor)) {
                                if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                    sumaUtilidad = sumaUtilidad + utilidad;
                                    sumaCosto = sumaCosto + costo;

                                    System.out.println("costo " + costo);

                                    String replace = margen.replace("%", "").replace(",", ".");
                                    Double valueOf = 0.0;
                                    try {
                                        valueOf = Double.valueOf(replace);
                                    } catch (Exception ex) {

                                    }

                                    if (valueOf >= 10) {
                                        sumaBono = sumaBono + utilidad;

                                        for (int r = 0; r < jTable3.getModel().getRowCount(); r++) {
                                            String foliox = jTable3.getModel().getValueAt(r, 2).toString();
                                            String vendedorx = jTable3.getModel().getValueAt(r, 7).toString();
                                            double utilidadx = Double.valueOf(jTable3.getModel().getValueAt(r, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                                            if (toString.equals(vendedorx)) {
                                                if (folio.equals(foliox)) {
                                                    sumaUtilidadNCBono = sumaUtilidadNCBono + utilidadx;
                                                }
                                            }
                                        }
                                    }

                                    if (origen.equals("Local")) {
                                        sumaUtilidadLocal = sumaUtilidadLocal + utilidad;
                                        sumaCostoLocal = sumaCostoLocal + costo;
                                    }
                                }
                            }
                        } else if (selected == true && selected2 == false) {
                            if (pagada.trim().equals("false")) {
                                if (toString.equals(vendedor)) {
                                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                        sumaUtilidad = sumaUtilidad + utilidad;
                                        sumaCosto = sumaCosto + costo;

                                        String replace = margen.replace("%", "").replace(",", ".");
                                        Double valueOf = 0.0;
                                        try {
                                            valueOf = Double.valueOf(replace);
                                        } catch (Exception ex) {

                                        }

                                        if (valueOf >= 10) {
                                            sumaBono = sumaBono + utilidad;

                                            for (int r = 0; r < jTable3.getModel().getRowCount(); r++) {
                                                String foliox = jTable3.getModel().getValueAt(r, 2).toString();
                                                String vendedorx = jTable3.getModel().getValueAt(r, 7).toString();
                                                double utilidadx = Double.valueOf(jTable3.getModel().getValueAt(r, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                                                if (toString.equals(vendedorx)) {
                                                    if (folio.equals(foliox)) {
                                                        sumaUtilidadNCBono = sumaUtilidadNCBono + utilidadx;
                                                    }
                                                }
                                            }
                                        }

                                        if (origen.equals("Local")) {
                                            sumaUtilidadLocal = sumaUtilidadLocal + utilidad;
                                            sumaCostoLocal = sumaCostoLocal + costo;
                                        }
                                    }
                                }
                            }
                        } else if (selected == false && selected2 == true) {
                            if (pagada.trim().equals("true")) {
                                if (toString.equals(vendedor)) {
                                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                        sumaUtilidad = sumaUtilidad + utilidad;
                                        sumaCosto = sumaCosto + costo;

                                        String replace = margen.replace("%", "").replace(",", ".");
                                        Double valueOf = 0.0;
                                        try {
                                            valueOf = Double.valueOf(replace);
                                        } catch (Exception ex) {

                                        }

                                        if (valueOf >= 10) {
                                            sumaBono = sumaBono + utilidad;

                                            for (int r = 0; r < jTable3.getModel().getRowCount(); r++) {
                                                String foliox = jTable3.getModel().getValueAt(r, 2).toString();
                                                String vendedorx = jTable3.getModel().getValueAt(r, 7).toString();
                                                double utilidadx = Double.valueOf(jTable3.getModel().getValueAt(r, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                                                if (toString.equals(vendedorx)) {
                                                    if (folio.equals(foliox)) {
                                                        sumaUtilidadNCBono = sumaUtilidadNCBono + utilidadx;
                                                    }
                                                }
                                            }
                                        }

                                        if (origen.equals("Local")) {
                                            sumaUtilidadLocal = sumaUtilidadLocal + utilidad;
                                            sumaCostoLocal = sumaCostoLocal + costo;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    double porcentaje = (((sumaUtilidadLocal) - sumaUtilidadNCLocal) / ((sumaCostoLocal) - sumaCostoNCLocal)) * 100;

                    System.out.println("sumaUtilidad-----> " + sumaUtilidad);
                    System.out.println("sumaUtilidadNC-----> " + sumaUtilidadNC);
                    System.out.println("sumaCosto-----> " + sumaCosto);
                    System.out.println("sumaCostoNC-----> " + sumaCostoNC);

                    System.out.println("toString " + toString);
                    System.out.println("sumaFlete " + sumaFlete);
                    System.out.println("porcentaje " + porcentaje);
                    System.out.println("sumaUtilidad " + sumaUtilidad);
                    System.out.println("sumaUtilidadNC " + sumaUtilidadNC);
                    System.out.println("sumaFlete " + sumaFlete);

                    double name = (sumaUtilidad - sumaUtilidadNC - sumaFlete) * 0.1;

                    double namex = 0.0;
                    if (porcentaje >= 10) {
                        namex = (sumaBono - sumaUtilidadNCBono - sumaFlete) * 0.05;
                    }

                    if (toString.equals("FRANCESCA PEREZ") || toString.equals("MARIO BRITO") || toString.equals("JUAN PABLO ARANDA") || toString.equals("CARLOS SEREY")) {
                        sumaUtilidad1 = sumaUtilidad1 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                    }

                    if (toString.equals("GONZALO ORDENES") || toString.equals("SERGIO HIDALGO") || toString.equals("GROVER IBACETA") || toString.equals("CLAUDIA RIQUELME")) {
                        sumaUtilidad2 = sumaUtilidad2 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                    }

                    filaTabla5[0] = toString;

                    String format = nf.format(name);
                    String[] split = format.split(",");

                    try {
                        filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla5[1] = "$ " + split[0];
                        }
                    }

                    format = nf.format(namex);
                    split = format.split(",");

                    try {
                        filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla5[2] = "$ " + split[0];
                        }
                    }

                    format = nf.format(name + namex);
                    split = format.split(",");

                    try {
                        filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla5[3] = "$ " + split[0];
                        }
                    }

                    if (tipo == 0) {
                        modelTabla5.addRow(filaTabla5);
                    } else {
                        if (nombrex.equals(toString)) {
                            modelTabla5.addRow(filaTabla5);
                        }
                    }
                }
            }
            double sumaUtilidadTotal = sumaUtilidad1 + sumaUtilidad2;

            double porcentajeVega = ((sumaUtilidad1 * 100) / sumaUtilidadTotal) / 100;
            double porcentajeMaturana = ((sumaUtilidad2 * 100) / sumaUtilidadTotal) / 100;
            double totalVega = 0;
            double totalMaturana = 0;

            if (sumaUtilidadTotal >= 21000000 && sumaUtilidadTotal <= 29999999) {
                totalVega = 500000 * porcentajeVega;
                totalMaturana = 500000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 30000000 && sumaUtilidadTotal <= 39999999) {
                totalVega = 700000 * porcentajeVega;
                totalMaturana = 700000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 40000000 && sumaUtilidadTotal <= 49999999) {
                totalVega = 800000 * porcentajeVega;
                totalMaturana = 800000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 50000000 && sumaUtilidadTotal <= 59999999) {
                totalVega = 900000 * porcentajeVega;
                totalMaturana = 900000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 60000000 && sumaUtilidadTotal <= 69999999) {
                totalVega = 1000000 * porcentajeVega;
                totalMaturana = 1000000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 70000000 && sumaUtilidadTotal <= 79999999) {
                totalVega = 1100000 * porcentajeVega;
                totalMaturana = 1100000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 80000000 && sumaUtilidadTotal <= 89999999) {
                totalVega = 1200000 * porcentajeVega;
                totalMaturana = 1200000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 90000000 && sumaUtilidadTotal <= 99999999) {
                totalVega = 1300000 * porcentajeVega;
                totalMaturana = 1300000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 100000000 && sumaUtilidadTotal <= 109999999) {
                totalVega = 1400000 * porcentajeVega;
                totalMaturana = 1400000 * porcentajeMaturana;
            } else if (sumaUtilidadTotal >= 110000000 && sumaUtilidadTotal <= 119999999) {
                totalVega = 1500000 * porcentajeVega;
                totalMaturana = 1500000 * porcentajeMaturana;
            }

            filaTabla5[0] = "EDUARDO VEGA";

            String format = nf.format(totalVega);
            String[] split = format.split(",");

            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
            } catch (Exception ex) {
                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                } catch (Exception exx) {
                    filaTabla5[1] = "$ " + split[0];
                }
            }

            filaTabla5[2] = "";
            filaTabla5[3] = "";

            if (tipo == 0) {
                modelTabla5.addRow(filaTabla5);
            } else {
                if (nombrex.equals("EDUARDO VEGA")) {
                    modelTabla5.addRow(filaTabla5);
                }
            }

            filaTabla5[0] = "CARLOS MATURANA";

            format = nf.format(totalMaturana);
            split = format.split(",");

            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
            } catch (Exception ex) {
                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                } catch (Exception exx) {
                    filaTabla5[1] = "$ " + split[0];
                }
            }

            filaTabla5[2] = "";
            filaTabla5[3] = "";

            if (tipo == 0) {
                modelTabla5.addRow(filaTabla5);
            } else {
                if (nombrex.equals("CARLOS MATURANA")) {
                    modelTabla5.addRow(filaTabla5);
                }
            }

            filaTabla5[0] = "VICTOR ESPINOZA R.";

            format = nf.format(sumaNeto * 0.003);
            split = format.split(",");

            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
            } catch (Exception ex) {
                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                } catch (Exception exx) {
                    filaTabla5[1] = "$ " + split[0];
                }
            }

            filaTabla5[2] = "";
            filaTabla5[3] = "";

            if (tipo == 0) {
                modelTabla5.addRow(filaTabla5);
            } else {
                if (nombrex.equals("VICTOR ESPINOZA R.")) {
                    modelTabla5.addRow(filaTabla5);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static void quitarFiltroRecuadroDos() {
        try {
            ((DefaultTableModel) jTable5.getModel()).setNumRows(0);
        } catch (Exception ex) {

        }

        String nombrex = VentanaLogin.nombrex;
        int tipo = VentanaLogin.tipo;

        double sumaUtilidad1 = 0;
        double sumaUtilidad2 = 0;
        double sumaNeto = 0;
        double sumaUtilidadTotal = 0;

        Locale chileLocale = new Locale("es", "CL");
        NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

        Object[] filaTabla5 = new Object[4];
        DefaultTableModel modelTabla5 = (DefaultTableModel) jTable5.getModel();

        for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
            double neto = Double.valueOf(jTable2.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));
            double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));

            if (utilidad > 0) {
                sumaNeto = sumaNeto + neto;
            }
            sumaUtilidadTotal = sumaUtilidadTotal + utilidad;
        }

        System.out.println("sumaUtilidadTotal " + sumaUtilidadTotal);
        System.out.println("sumaNeto " + sumaNeto);

        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            String toString = jComboBox1.getItemAt(i);

            if (!toString.equals("EDUARDO VEGA") && !toString.equals("VICTOR ESPINOZA R.") && !toString.equals("CARLOS MATURANA") && !toString.equals("Todos") && !toString.equals("CHERYL BERRIOS")) {
                double sumaUtilidadNCBono = 0;
                double sumaUtilidadNCLocal = 0;
                double sumaUtilidadNC = 0;
                double sumaUtilidad = 0;
                double sumaUtilidadLocal = 0;
                double sumaCostoNCLocal = 0;
                double sumaCostoNC = 0;
                double sumaFlete = 0;
                double sumaCosto = 0;
                double sumaCostoLocal = 0;
                double sumaBono = 0;

                for (int x = 0; x < jTable4.getModel().getRowCount(); x++) {
                    String vendedor = jTable4.getValueAt(x, 2).toString();
                    double monto = Double.valueOf(jTable4.getValueAt(x, 4).toString().replace(".", "").replace(",", ".").replace("$", ""));

                    if (toString.equals(vendedor)) {
                        sumaFlete = sumaFlete + monto;
                    }
                }

                for (int j = 0; j < jTable3.getModel().getRowCount(); j++) {
                    String vendedor = jTable3.getModel().getValueAt(j, 7).toString();
                    String origen = jTable3.getModel().getValueAt(j, 9).toString();
                    double costo = Double.valueOf(jTable3.getModel().getValueAt(j, 4).toString().replace("$", "").replace(".", "").replace(",", "."));
                    double utilidad = Double.valueOf(jTable3.getModel().getValueAt(j, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                    if (toString.equals(vendedor)) {
                        sumaUtilidadNC = sumaUtilidadNC + utilidad;
                        sumaCostoNC = sumaCostoNC + costo;

                        if (origen.equals("Local")) {
                            sumaUtilidadNCLocal = sumaUtilidadNCLocal + utilidad;
                            sumaCostoNCLocal = sumaCostoNCLocal + costo;
                        }
                    }
                }

                for (int j = 0; j < jTable2.getModel().getRowCount(); j++) {
                    String folio = jTable2.getModel().getValueAt(j, 1).toString();
                    String vendedor = jTable2.getModel().getValueAt(j, 4).toString();
                    double costo = Double.valueOf(jTable2.getModel().getValueAt(j, 5).toString().replace("$", "").replace(".", "").replace(",", "."));
                    double utilidad = Double.valueOf(jTable2.getModel().getValueAt(j, 7).toString().replace("$", "").replace(".", "").replace(",", "."));
                    String margen = jTable2.getModel().getValueAt(j, 8).toString();
                    String origen = jTable2.getModel().getValueAt(j, 9).toString();
                    String fecha = jTable2.getModel().getValueAt(j, 0).toString();
                    String pagada = jTable2.getModel().getValueAt(i, 11).toString();

                    if (toString.equals(vendedor)) {

                        sumaUtilidad = sumaUtilidad + utilidad;
                        sumaCosto = sumaCosto + costo;

                        String replace = margen.replace("%", "").replace(",", ".");
                        Double valueOf = 0.0;
                        try {
                            valueOf = Double.valueOf(replace);
                        } catch (Exception ex) {

                        }

                        if (valueOf >= 10) {
                            sumaBono = sumaBono + utilidad;

                            for (int r = 0; r < jTable3.getModel().getRowCount(); r++) {
                                String foliox = jTable3.getModel().getValueAt(r, 2).toString();
                                String vendedorx = jTable3.getModel().getValueAt(r, 7).toString();
                                double utilidadx = Double.valueOf(jTable3.getModel().getValueAt(r, 6).toString().replace("$", "").replace(".", "").replace(",", "."));

                                if (toString.equals(vendedorx)) {
                                    if (folio.equals(foliox)) {
                                        sumaUtilidadNCBono = sumaUtilidadNCBono + utilidadx;
                                    }
                                }
                            }
                        }

                        if (origen.equals("Local")) {
                            sumaUtilidadLocal = sumaUtilidadLocal + utilidad;
                            sumaCostoLocal = sumaCostoLocal + costo;
                        }
                    }
                }

                double porcentaje = (((sumaUtilidadLocal) - sumaUtilidadNCLocal) / ((sumaCostoLocal) - sumaCostoNCLocal)) * 100;

                System.out.println("toString " + toString);
                System.out.println("sumaFlete " + sumaFlete);
                System.out.println("porcentaje " + porcentaje);
                System.out.println("sumaUtilidad " + sumaUtilidad);
                System.out.println("sumaUtilidadNC " + sumaUtilidadNC);
                System.out.println("sumaFlete " + sumaFlete);

                double name = (sumaUtilidad - sumaUtilidadNC - sumaFlete) * 0.1;

                double namex = 0.0;
                if (porcentaje >= 10) {
                    namex = (sumaBono - sumaUtilidadNCBono - sumaFlete) * 0.05;
                }

                if (toString.equals("FRANCESCA PEREZ") || toString.equals("MARIO BRITO") || toString.equals("JUAN PABLO ARANDA") || toString.equals("CARLOS SEREY")) {
                    sumaUtilidad1 = sumaUtilidad1 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                }

                if (toString.equals("GONZALO ORDENES") || toString.equals("SERGIO HIDALGO") || toString.equals("GROVER IBACETA") || toString.equals("CLAUDIA RIQUELME")) {
                    sumaUtilidad2 = sumaUtilidad2 + (sumaUtilidad - sumaUtilidadNC - sumaFlete);
                }

                filaTabla5[0] = toString;

                String format = nf.format(name);
                String[] split = format.split(",");

                try {
                    filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[1] = "$ " + split[0];
                    }
                }

                format = nf.format(namex);
                split = format.split(",");

                try {
                    filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[2] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[2] = "$ " + split[0];
                    }
                }

                format = nf.format(name + namex);
                split = format.split(",");

                try {
                    filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla5[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla5[3] = "$ " + split[0];
                    }
                }

                if (tipo == 0) {
                    modelTabla5.addRow(filaTabla5);
                } else {
                    if (nombrex.equals(toString)) {
                        modelTabla5.addRow(filaTabla5);
                    }
                }
            }
        }

        double name = sumaUtilidad1 + sumaUtilidad2;

        double porcentajeVega = ((sumaUtilidad1 * 100) / name) / 100;
        double porcentajeMaturana = ((sumaUtilidad2 * 100) / name) / 100;
        double totalVega = 0;
        double totalMaturana = 0;

        if (sumaUtilidadTotal >= 21000000 && sumaUtilidadTotal <= 29999999) {
            totalVega = 500000 * porcentajeVega;
            totalMaturana = 500000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 30000000 && sumaUtilidadTotal <= 39999999) {
            totalVega = 700000 * porcentajeVega;
            totalMaturana = 700000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 40000000 && sumaUtilidadTotal <= 49999999) {
            totalVega = 800000 * porcentajeVega;
            totalMaturana = 800000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 50000000 && sumaUtilidadTotal <= 59999999) {
            totalVega = 900000 * porcentajeVega;
            totalMaturana = 900000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 60000000 && sumaUtilidadTotal <= 69999999) {
            totalVega = 1000000 * porcentajeVega;
            totalMaturana = 1000000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 70000000 && sumaUtilidadTotal <= 79999999) {
            totalVega = 1100000 * porcentajeVega;
            totalMaturana = 1100000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 80000000 && sumaUtilidadTotal <= 89999999) {
            totalVega = 1200000 * porcentajeVega;
            totalMaturana = 1200000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 90000000 && sumaUtilidadTotal <= 99999999) {
            totalVega = 1300000 * porcentajeVega;
            totalMaturana = 1300000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 100000000 && sumaUtilidadTotal <= 109999999) {
            totalVega = 1400000 * porcentajeVega;
            totalMaturana = 1400000 * porcentajeMaturana;
        } else if (sumaUtilidadTotal >= 110000000 && sumaUtilidadTotal <= 119999999) {
            totalVega = 1500000 * porcentajeVega;
            totalMaturana = 1500000 * porcentajeMaturana;
        }

        filaTabla5[0] = "EDUARDO VEGA";

        String format = nf.format(totalVega);
        String[] split = format.split(",");

        try {
            filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
        } catch (Exception ex) {
            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
            } catch (Exception exx) {
                filaTabla5[1] = "$ " + split[0];
            }
        }

        filaTabla5[2] = "";
        filaTabla5[3] = "";

        if (tipo == 0) {
            modelTabla5.addRow(filaTabla5);
        } else {
            if (nombrex.equals("EDUARDO VEGA")) {
                modelTabla5.addRow(filaTabla5);
            }
        }

        filaTabla5[0] = "CARLOS MATURANA";

        format = nf.format(totalMaturana);
        split = format.split(",");

        try {
            filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
        } catch (Exception ex) {
            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
            } catch (Exception exx) {
                filaTabla5[1] = "$ " + split[0];
            }
        }

        filaTabla5[2] = "";
        filaTabla5[3] = "";

        if (tipo == 0) {
            modelTabla5.addRow(filaTabla5);
        } else {
            if (nombrex.equals("CARLOS MATURANA")) {
                modelTabla5.addRow(filaTabla5);
            }
        }

        filaTabla5[0] = "VICTOR ESPINOZA R.";

        format = nf.format(sumaNeto * 0.003);
        split = format.split(",");

        try {
            filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 2);
        } catch (Exception ex) {
            try {
                filaTabla5[1] = "$ " + split[0] + "," + split[1].substring(0, 1);
            } catch (Exception exx) {
                filaTabla5[1] = "$ " + split[0];
            }
        }

        filaTabla5[2] = "";
        filaTabla5[3] = "";

        if (tipo == 0) {
            modelTabla5.addRow(filaTabla5);
        } else {
            if (nombrex.equals("VICTOR ESPINOZA R.")) {
                modelTabla5.addRow(filaTabla5);
            }
        }

        rSDateChooser6.setDatoFecha(null);
        rSDateChooser7.setDatoFecha(null);
    }

    public static void filtraRecuadroUno() throws ParseException {
        jTable2.setRowSorter(null);

        Date datoFecha = rSDateChooser1.getDatoFecha();
        Date datoFecha2 = rSDateChooser2.getDatoFecha();

        if (!jComboBox4.getSelectedItem().toString().equals("-")) {
            // <editor-fold>
            String numeroOCBox = jComboBox4.getSelectedItem().toString();

            Double sumaNeto0 = 0.0;
            Double sumaNeto = 0.0;
            Double sumaUtilidad0 = 0.0;
            Double sumaUtilidad = 0.0;
            Double sumaCosto0 = 0.0;
            Double sumaCosto = 0.0;

            for (int i = 0; i < jTable3.getRowCount(); i++) {
                try {
                    String costo = jTable3.getValueAt(i, 4).toString();
                    String neto = jTable3.getValueAt(i, 5).toString();
                    String utilidad = jTable3.getValueAt(i, 6).toString();
                    String numeroOC = jTable3.getValueAt(i, 10).toString();

                    if (numeroOCBox.equals(numeroOC)) {
                        System.out.println("Caso OC = OCBox");
                        System.out.println("pre Caso 1");

                        String replace = neto.replace("$ ", "");
                        String replace1 = replace.replace(".", "");
                        String replace2 = replace1.replace(",", ".");
                        sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                        replace = utilidad.replace("$ ", "");
                        replace1 = replace.replace(".", "");
                        replace2 = replace1.replace(",", ".");
                        sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                        replace = costo.replace("$ ", "");
                        replace1 = replace.replace(".", "");
                        replace2 = replace1.replace(",", ".");
                        sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                    }
                } catch (Exception ex) {
                    System.out.println("ex " + ex);
                }
            }

            double sumaTotalFlete = 0.0;

            for (int i = 0; i < jTable4.getRowCount(); i++) {
                String total = jTable4.getValueAt(i, 4).toString();

                System.out.println("total " + total);

                if (numeroOCBox.equals("")) {
                    System.out.println("Caso OC = OCBox");
                    System.out.println("pre Caso 1.1");
                    String replace = total.replace("$", "");
                    String replace1 = replace.replace(".", "");
                    sumaTotalFlete = sumaTotalFlete + Double.valueOf(replace1);
                }
            }

            Locale chileLocale = new Locale("es", "CL");
            NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

//            double sumaTotalFlete10 = sumaTotalFlete * 0.1;
            String format = nf.format(sumaTotalFlete);
            String[] split = format.split(",");

            try {
                jLabel23.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel23.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel23.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaUtilidad0);
            split = format.split(",");

            try {
                jLabel8.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel8.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel8.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaNeto0);
            split = format.split(",");

            try {
                jLabel12.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel12.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel12.setText("$ " + split[0]);
                }
            }

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                String costo = jTable2.getValueAt(i, 5).toString();
                String neto = jTable2.getValueAt(i, 6).toString();
                String utilidad = jTable2.getValueAt(i, 7).toString();
                String numeroOC = jTable2.getValueAt(i, 10).toString();

                if (numeroOCBox.equals(numeroOC)) {
                    System.out.println("Caso OC = OCBox");

                    String replace = neto.replace("$ ", "");
                    String replace1 = replace.replace(".", "");
                    String replace2 = replace1.replace(",", ".");
                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                    replace = utilidad.replace("$ ", "");
                    replace1 = replace.replace(".", "");
                    replace2 = replace1.replace(",", ".");
                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                    replace = costo.replace("$ ", "");
                    replace1 = replace.replace(".", "");
                    replace2 = replace1.replace(",", ".");
                    sumaCosto = sumaCosto + Double.valueOf(replace2);
                }
            }

            format = nf.format(sumaNeto);
            split = format.split(",");

            try {
                jLabel4.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel4.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel4.setText("$ " + split[0]);
                }
            }

            sumaUtilidad = sumaUtilidad - sumaTotalFlete;
            format = nf.format(sumaUtilidad);
            split = format.split(",");

            try {
                jLabel5.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel5.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel5.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaUtilidad - sumaUtilidad0);
            split = format.split(",");

            try {
                jLabel10.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel10.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel10.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaNeto - sumaNeto0);
            split = format.split(",");

            try {
                jLabel14.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel14.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel14.setText("$ " + split[0]);
                }
            }

            sumaCosto = sumaCosto + sumaTotalFlete;

            format = nf.format(sumaCosto);
            split = format.split(",");

            try {
                jLabel20.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel20.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel20.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaCosto0);
            split = format.split(",");

            try {
                jLabel18.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel18.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel18.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaCosto - sumaCosto0);
            split = format.split(",");

            try {
                jLabel16.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel16.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel16.setText("$ " + split[0]);
                }
            }

            double name = ((sumaUtilidad - sumaUtilidad0) / (sumaCosto - sumaCosto0)) * 100;
            jLabel6.setText(new DecimalFormat("#.##").format(name) + "%");

            System.out.println("//////");
            // </editor-fold>
        } else {
            String vendedorBox = jComboBox1.getSelectedItem().toString();
            String origenBox = jComboBox2.getSelectedItem().toString();

            boolean selected = jCheckBox1.isSelected();
            boolean selected2 = jCheckBox2.isSelected();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(datoFecha);
            System.out.println(date);

            String date2 = simpleDateFormat.format(datoFecha2);
            System.out.println(date2);

            Double sumaNeto0 = 0.0;
            Double sumaNeto = 0.0;
            Double sumaUtilidad0 = 0.0;
            Double sumaUtilidad = 0.0;
            Double sumaCosto0 = 0.0;
            Double sumaCosto = 0.0;

            for (int i = 0; i < jTable3.getRowCount(); i++) {
                if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
                    String fecha = jTable3.getValueAt(i, 0).toString();
                    String costo = jTable3.getValueAt(i, 4).toString();
                    String neto = jTable3.getValueAt(i, 5).toString();
                    String utilidad = jTable3.getValueAt(i, 6).toString();
                    String vendedor = jTable3.getValueAt(i, 7).toString();
                    String origen = jTable3.getValueAt(i, 9).toString();

                    System.out.println("fecha " + fecha);

                    if (vendedorBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            System.out.println("pre Caso 1");

                            String replace = neto.replace("$ ", "");
                            String replace1 = replace.replace(".", "");
                            String replace2 = replace1.replace(",", ".");
                            sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                            replace = utilidad.replace("$ ", "");
                            replace1 = replace.replace(".", "");
                            replace2 = replace1.replace(",", ".");
                            sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                            replace = costo.replace("$ ", "");
                            replace1 = replace.replace(".", "");
                            replace2 = replace1.replace(",", ".");
                            sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                        }
                    } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            if (vendedor.equals(vendedorBox)) {
                                System.out.println("pre Caso 3");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                            }
                        }
                  
                } else {
                    try {
                        String fecha = jTable3.getValueAt(i, 0).toString();
                        String costo = jTable3.getValueAt(i, 4).toString();
                        String neto = jTable3.getValueAt(i, 5).toString();
                        String utilidad = jTable3.getValueAt(i, 6).toString();
                        String vendedor = jTable3.getValueAt(i, 7).toString();
                        String origen = jTable3.getValueAt(i, 9).toString();

                        System.out.println("fecha " + fecha);

                        if (vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                System.out.println("pre Caso 1");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                            }
                        } else if (vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (origen.equals(origenBox)) {
                                    System.out.println("pre Caso 2");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (vendedor.equals(vendedorBox)) {
                                    System.out.println("pre Caso 3");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (origen.equals(origenBox)) {
                                    if (vendedor.equals(vendedorBox)) {
                                        System.out.println("pre Caso 4");

                                        String replace = neto.replace("$ ", "");
                                        String replace1 = replace.replace(".", "");
                                        String replace2 = replace1.replace(",", ".");
                                        sumaNeto0 = sumaNeto0 + Double.valueOf(replace2);

                                        replace = utilidad.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaUtilidad0 = sumaUtilidad0 + Double.valueOf(replace2);

                                        replace = costo.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaCosto0 = sumaCosto0 + Double.valueOf(replace2);
                                    }
                                }
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                    }
                }
            }

            double sumaTotalFlete = 0.0;

            for (int i = 0; i < jTable4.getRowCount(); i++) {
                String fecha = jTable4.getValueAt(i, 0).toString();
                String vendedor = jTable4.getValueAt(i, 2).toString();
                String total = jTable4.getValueAt(i, 4).toString();

                System.out.println("fecha " + fecha);
                System.out.println("vendedor " + vendedor);
                System.out.println("total " + total);

                System.out.println("date " + date);
                System.out.println("date2 " + date2);

                String[] split = fecha.split("-");
                fecha = split[2] + "-" + split[1] + "-" + split[0];

                if (vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                        System.out.println("pre Caso 1.1");
                        String replace = total.replace("$", "");
                        String replace1 = replace.replace(".", "");
                        sumaTotalFlete = sumaTotalFlete + Double.valueOf(replace1);
                    }
                } else if (vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                        System.out.println("pre Caso 1.2");
                        String replace = total.replace("$", "");
                        String replace1 = replace.replace(".", "");
                        sumaTotalFlete = sumaTotalFlete + Double.valueOf(replace1);
                    }
                } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                        if (vendedor.equals(vendedorBox)) {
                            System.out.println("pre Caso 1.3");
                            String replace = total.replace("$", "");
                            String replace1 = replace.replace(".", "");
                            sumaTotalFlete = sumaTotalFlete + Double.valueOf(replace1);
                        }
                    }
                } else if (!vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                    if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                        if (vendedor.equals(vendedorBox)) {
                            System.out.println("pre Caso 1.4");
                            String replace = total.replace("$", "");
                            String replace1 = replace.replace(".", "");
                            sumaTotalFlete = sumaTotalFlete + Double.valueOf(replace1);
                        }
                    }
                }
            }

            Locale chileLocale = new Locale("es", "CL");
            NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

//            double sumaTotalFlete10 = sumaTotalFlete * 0.1;
            String format = nf.format(sumaTotalFlete);
            String[] split = format.split(",");

            try {
                jLabel23.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel23.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel23.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaUtilidad0);
            split = format.split(",");

            try {
                jLabel8.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel8.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel8.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaNeto0);
            split = format.split(",");

            try {
                jLabel12.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel12.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel12.setText("$ " + split[0]);
                }
            }

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                String fecha = jTable2.getValueAt(i, 0).toString();
                String vendedor = jTable2.getValueAt(i, 4).toString();
                String costo = jTable2.getValueAt(i, 5).toString();
                String neto = jTable2.getValueAt(i, 6).toString();
                String utilidad = jTable2.getValueAt(i, 7).toString();
                String origen = jTable2.getValueAt(i, 9).toString();
                String pagada = jTable2.getValueAt(i, 11).toString();

                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                Date parse = dateFormat.parse(fecha.toString());
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                fecha = dateFormat.format(parse);

//                System.out.println("fecha " + fecha);
//
//                System.out.println("" + Integer.valueOf(fecha.replace("-", "")));
//                System.out.println("" + Integer.valueOf(date.replace("-", "")));
//                System.out.println("" + Integer.valueOf(date2.replace("-", "")));
//                System.out.println("");
                if (selected == true && selected2 == true) {
                    if (vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            System.out.println("Caso 1");

                            String replace = neto.replace("$ ", "");
                            String replace1 = replace.replace(".", "");
                            String replace2 = replace1.replace(",", ".");
                            sumaNeto = sumaNeto + Double.valueOf(replace2);

                            replace = utilidad.replace("$ ", "");
                            replace1 = replace.replace(".", "");
                            replace2 = replace1.replace(",", ".");
                            sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                            replace = costo.replace("$ ", "");
                            replace1 = replace.replace(".", "");
                            replace2 = replace1.replace(",", ".");
                            sumaCosto = sumaCosto + Double.valueOf(replace2);

                            System.out.println("replace2 " + replace2);
                        }
                    } else if (vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            System.out.println("origen " + origen);
                            System.out.println("origenBox " + origenBox);
                            if (origen.equals(origenBox)) {
                                System.out.println("Caso 2");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto = sumaNeto + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto = sumaCosto + Double.valueOf(replace2);

                                System.out.println("replace2 " + replace2);
                            }
                        }
                    } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            if (vendedor.equals(vendedorBox)) {
                                System.out.println("Caso 3");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto = sumaNeto + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto = sumaCosto + Double.valueOf(replace2);

                                System.out.println("replace2 " + replace2);
                            }
                        }
                    } else if (!vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                        if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                            if (origen.equals(origenBox)) {
                                if (vendedor.equals(vendedorBox)) {
                                    System.out.println("Caso 4");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto = sumaCosto + Double.valueOf(replace2);

                                    System.out.println("replace2 " + replace2);
                                }
                            }
                        }
                    }
                } else if (selected == true && selected2 == false) {
                    if (pagada.trim().equals("false")) {
                        if (vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                System.out.println("Caso 1");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto = sumaNeto + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto = sumaCosto + Double.valueOf(replace2);

                                System.out.println("replace2 " + replace2);
                            }
                        } else if (vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                System.out.println("origen " + origen);
                                System.out.println("origenBox " + origenBox);
                                if (origen.equals(origenBox)) {
                                    System.out.println("Caso 2");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto = sumaCosto + Double.valueOf(replace2);

                                    System.out.println("replace2 " + replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (vendedor.equals(vendedorBox)) {
                                    System.out.println("Caso 3");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto = sumaCosto + Double.valueOf(replace2);

                                    System.out.println("replace2 " + replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (origen.equals(origenBox)) {
                                    if (vendedor.equals(vendedorBox)) {
                                        System.out.println("Caso 4");

                                        String replace = neto.replace("$ ", "");
                                        String replace1 = replace.replace(".", "");
                                        String replace2 = replace1.replace(",", ".");
                                        sumaNeto = sumaNeto + Double.valueOf(replace2);

                                        replace = utilidad.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                        replace = costo.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaCosto = sumaCosto + Double.valueOf(replace2);

                                        System.out.println("replace2 " + replace2);
                                    }
                                }
                            }
                        }
                    }
                } else if (selected == false && selected2 == true) {
                    if (pagada.trim().equals("true")) {
                        if (vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                System.out.println("Caso 1");

                                String replace = neto.replace("$ ", "");
                                String replace1 = replace.replace(".", "");
                                String replace2 = replace1.replace(",", ".");
                                sumaNeto = sumaNeto + Double.valueOf(replace2);

                                replace = utilidad.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                replace = costo.replace("$ ", "");
                                replace1 = replace.replace(".", "");
                                replace2 = replace1.replace(",", ".");
                                sumaCosto = sumaCosto + Double.valueOf(replace2);

                                System.out.println("replace2 " + replace2);
                            }
                        } else if (vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                System.out.println("origen " + origen);
                                System.out.println("origenBox " + origenBox);
                                if (origen.equals(origenBox)) {
                                    System.out.println("Caso 2");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto = sumaCosto + Double.valueOf(replace2);

                                    System.out.println("replace2 " + replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (vendedor.equals(vendedorBox)) {
                                    System.out.println("Caso 3");

                                    String replace = neto.replace("$ ", "");
                                    String replace1 = replace.replace(".", "");
                                    String replace2 = replace1.replace(",", ".");
                                    sumaNeto = sumaNeto + Double.valueOf(replace2);

                                    replace = utilidad.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                    replace = costo.replace("$ ", "");
                                    replace1 = replace.replace(".", "");
                                    replace2 = replace1.replace(",", ".");
                                    sumaCosto = sumaCosto + Double.valueOf(replace2);

                                    System.out.println("replace2 " + replace2);
                                }
                            }
                        } else if (!vendedorBox.equals("Todos") && !origenBox.equals("Todos")) {
                            if (Integer.valueOf(fecha.replace("-", "")) >= Integer.valueOf(date.replace("-", "")) && Integer.valueOf(fecha.replace("-", "")) <= Integer.valueOf(date2.replace("-", ""))) {
                                if (origen.equals(origenBox)) {
                                    if (vendedor.equals(vendedorBox)) {
                                        System.out.println("Caso 4");

                                        String replace = neto.replace("$ ", "");
                                        String replace1 = replace.replace(".", "");
                                        String replace2 = replace1.replace(",", ".");
                                        sumaNeto = sumaNeto + Double.valueOf(replace2);

                                        replace = utilidad.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaUtilidad = sumaUtilidad + Double.valueOf(replace2);

                                        replace = costo.replace("$ ", "");
                                        replace1 = replace.replace(".", "");
                                        replace2 = replace1.replace(",", ".");
                                        sumaCosto = sumaCosto + Double.valueOf(replace2);

                                        System.out.println("replace2 " + replace2);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("sumaNeto----------> " + sumaNeto);
            System.out.println("sumaUtilidad---------> " + sumaUtilidad);
            System.out.println("sumaUtilidad0---------> " + sumaUtilidad0);
            System.out.println("sumaCosto---------> " + sumaCosto);
            System.out.println("sumaCosto0---------> " + sumaCosto0);
            System.out.println("sumaTotalFlete--------> " + sumaTotalFlete);

            format = nf.format(sumaNeto);
            split = format.split(",");

            try {
                jLabel4.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel4.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel4.setText("$ " + split[0]);
                }
            }

            if (origenBox.equals("Todos")) {
                sumaUtilidad = sumaUtilidad - sumaTotalFlete;
                format = nf.format(sumaUtilidad);
                split = format.split(",");
            } else {
                format = nf.format(sumaUtilidad);
                split = format.split(",");
            }

            try {
                jLabel5.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel5.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel5.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaUtilidad - sumaUtilidad0);
            split = format.split(",");

            try {
                jLabel10.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel10.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel10.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaNeto - sumaNeto0);
            split = format.split(",");

            try {
                jLabel14.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel14.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel14.setText("$ " + split[0]);
                }
            }

            if (origenBox.equals("Todods")) {
                sumaCosto = sumaCosto + sumaTotalFlete;
                format = nf.format(sumaCosto);
                split = format.split(",");
            } else {
                format = nf.format(sumaCosto);
                split = format.split(",");
            }

            try {
                jLabel20.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel20.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel20.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaCosto0);
            split = format.split(",");

            try {
                jLabel18.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel18.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel18.setText("$ " + split[0]);
                }
            }

            format = nf.format(sumaCosto - sumaCosto0);
            split = format.split(",");

            try {
                jLabel16.setText("$ " + split[0] + "," + split[1].substring(0, 2));
            } catch (Exception ex) {
                try {
                    jLabel16.setText("$ " + split[0] + "," + split[1].substring(0, 1));
                } catch (Exception exx) {
                    jLabel16.setText("$ " + split[0]);
                }
            }

            double name = ((sumaUtilidad - sumaUtilidad0) / (sumaCosto - sumaCosto0)) * 100;
            jLabel6.setText(new DecimalFormat("#.##").format(name) + "%");

            System.out.println("//////");
        }

        String toString = jComboBox1.getSelectedItem().toString();
        String toString1 = jComboBox2.getSelectedItem().toString();

        boolean selected = jCheckBox2.isSelected();
        boolean selected1 = jCheckBox1.isSelected();

        String valueOf = String.valueOf(selected);
        String valueOf1 = String.valueOf(selected1);

        String condicion = "";
        if (valueOf.equals("true") && valueOf1.equals("true")) {
            condicion = "";
        } else if (valueOf.equals("true") && !valueOf1.equals("true")) {
            condicion = "true";
        } else if (!valueOf.equals("true") && valueOf1.equals("true")) {
            condicion = "false";
        }

        filter(datoFecha, datoFecha2, jTable2, toString, toString1, condicion);
    }

    public static void filter(Date startDate, Date endDate, JTable jTable, String vendedor, String origen, String pagada) {
        if (vendedor.equals("Todos")) {
            vendedor = "";
        }
        if (origen.equals("Todos")) {
            origen = "";
        }

        LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate minusDays = date.minusDays(1);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date datex = Date.from(minusDays.atStartOfDay(defaultZoneId).toInstant());

        LocalDate dateEnd = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate plusDays = dateEnd.plusDays(1);
        Date datexEnd = Date.from(plusDays.atStartOfDay(defaultZoneId).toInstant());

        List<RowFilter<Object, Object>> filters = new ArrayList<>(5);
        filters.add(RowFilter.dateFilter(ComparisonType.AFTER, datex));
        filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, datexEnd));
        filters.add(RowFilter.regexFilter(vendedor, 4));
        filters.add(RowFilter.regexFilter(origen, 9));
        filters.add(RowFilter.regexFilter(pagada, 11));

        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dtm);
        jTable.setRowSorter(tr);
        RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
        tr.setRowFilter(rf);
    }

    public static void graficaCarteraVendedor() throws IOException, SQLException {
        Principal.newJFrame.jButton6.setEnabled(false);
        Principal.jTable7.setVisible(false);

        Thread thread = new Thread(() -> {
            try {
                ((DefaultTableModel) jTable7.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }

            Date datoFecha = Principal.rSDateChooser4.getDatoFecha();
            Date datoFecha1 = Principal.rSDateChooser5.getDatoFecha();
            String vendedor = Principal.jComboBox5.getSelectedItem().toString();

            ArrayList<ClienteVE> selectXNombre = null;
            try {
                selectXNombre = clientesDAO.selectXNombre(vendedor);
            } catch (IOException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("datoFecha " + datoFecha);
            System.out.println("datoFecha1 " + datoFecha1);

            Object[] filaTabla7 = new Object[3];
            DefaultTableModel modelTabla7 = (DefaultTableModel) jTable7.getModel();

            selectXNombre.stream().forEach((ClienteVE clienteVE) -> {
                String rut = clienteVE.getRut();
                String razonSocial = clienteVE.getRazonSocial();

                System.out.println("razonSocial " + razonSocial);

                double sumaNeto = 0.0;

                for (int i = 0; i < jTable2.getModel().getRowCount(); i++) {
                    try {
                        String fechaTabla = jTable2.getModel().getValueAt(i, 0).toString();
                        String rutTabla = jTable2.getModel().getValueAt(i, 3).toString();
                        String vendedorTabla = jTable2.getModel().getValueAt(i, 4).toString();
                        String netoTabla = jTable2.getModel().getValueAt(i, 6).toString();

                        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                        Date parse = dateFormat.parse(fechaTabla);

                        DateFormat dateFormatx = new SimpleDateFormat("yyyy-MM-dd");
                        String strDate = dateFormatx.format(parse);
                        String replace = strDate.replace("-", "");
                        Integer valueOf = Integer.valueOf(replace);

                        String strDate1 = dateFormatx.format(datoFecha);
                        String replace1 = strDate1.replace("-", "");
                        Integer valueOf1 = Integer.valueOf(replace1);

                        String strDate2 = dateFormatx.format(datoFecha1);
                        String replace2 = strDate2.replace("-", "");
                        Integer valueOf2 = Integer.valueOf(replace2);

                        if (vendedor.equals(vendedorTabla)) {
                            if (rut.equals(rutTabla)) {

                                System.out.println(valueOf + " >= " + valueOf1);
                                System.out.println(valueOf + " <= " + valueOf2);
                                if (valueOf >= valueOf1 && valueOf <= valueOf2) {
                                    System.out.println(netoTabla.replace("$", "").replace(".", "").replace(",", ".").trim());
                                    sumaNeto = sumaNeto + Double.parseDouble(netoTabla.replace("$", "").replace(".", "").replace(",", ".").trim());
                                } else {
                                    System.out.println("   " + netoTabla.replace("$", "").replace(".", "").replace(",", "."));
                                }
                            }
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                for (int i = 0; i < jTable3.getRowCount(); i++) {
                    String fechaTabla = jTable3.getValueAt(i, 0).toString();
                    String rutTabla = jTable3.getValueAt(i, 1).toString();
                    String netoTabla = jTable3.getValueAt(i, 5).toString();
                    String vendedorTabla = jTable3.getValueAt(i, 7).toString();

                    DateFormat dateFormatx = new SimpleDateFormat("yyyy-MM-dd");

                    String replace = fechaTabla.replace("-", "");
                    Integer valueOf = Integer.valueOf(replace);

                    String strDate1 = dateFormatx.format(datoFecha);
                    String replace1 = strDate1.replace("-", "");
                    Integer valueOf1 = Integer.valueOf(replace1);

                    String strDate2 = dateFormatx.format(datoFecha1);
                    String replace2 = strDate2.replace("-", "");
                    Integer valueOf2 = Integer.valueOf(replace2);

                    if (vendedor.equals(vendedorTabla)) {
                        if (rut.equals(rutTabla)) {

                            System.out.println(valueOf + " >= " + valueOf1);
                            System.out.println(valueOf + " <= " + valueOf2);
                            if (valueOf >= valueOf1 && valueOf <= valueOf2) {
                                System.out.println(netoTabla.replace("$", "").replace(".", "").replace(",", ".").trim());
                                sumaNeto = sumaNeto - Double.valueOf(netoTabla.replace("$", "").replace(".", "").replace(",", ".").trim());
                            } else {
                                System.out.println("   " + netoTabla.replace("$", "").replace(".", "").replace(",", "."));
                            }
                        }
                    }
                }

                filaTabla7[0] = rut.trim();
                filaTabla7[1] = razonSocial.trim();

                DecimalFormat formato = new DecimalFormat("#,###");
                String valorFormateado = formato.format(sumaNeto);
                filaTabla7[2] = "$ " + valorFormateado.replace(",", ".");

                modelTabla7.addRow(filaTabla7);
            });

            jTable7.setModel(modelTabla7);

            TableRowSorter trs = new TableRowSorter(modelTabla7);
            trs.setComparator(2, new IntComparator());
            jTable7.setRowSorter(trs);

            ((DefaultTableCellRenderer) jTable7.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            resizeColumnWidth(jTable7);

            jTable7.setRowHeight(35);
            jTable7.setShowHorizontalLines(true);
            jTable7.setShowVerticalLines(true);

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            int columnCount = jTable7.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                jTable7.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
            renderer.setHorizontalAlignment(JLabel.CENTER);

            Principal.newJFrame.jButton6.setEnabled(true);
            Principal.jTable7.setVisible(true);
        });
        thread.start();
    }
}

class CustomRenderer implements TableCellRenderer {

    JPanel panel;
    JButton b;

    public CustomRenderer(String name, boolean bool) {
        panel = new javax.swing.JPanel();
        b = new javax.swing.JButton();
        b.setText(name);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        if (bool) {
            b.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }
}

class CustomEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel panel;
    JButton b;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditor(String nombre, boolean bool) {
        panel = new javax.swing.JPanel();
        b = new javax.swing.JButton();

        b.setText(nombre);
        b.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        if (bool) {
            b.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres eliminar?", "Eliminar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            stopCellEditing();

            int selectedRow = jTable4.getSelectedRow();
            System.out.println("selectedRow " + selectedRow);

            Flete flete = new Flete();
            flete.setFechaFa(jTable4.getValueAt(selectedRow, 0).toString());
            flete.setNumeroFa(jTable4.getValueAt(selectedRow, 1).toString());
            flete.setVendedor(jTable4.getValueAt(selectedRow, 2).toString());
            flete.setMontoFa(jTable4.getValueAt(selectedRow, 3).toString().replace("$", "").replace(".", "").trim());
            flete.setMontoFaVendedor(jTable4.getValueAt(selectedRow, 4).toString().replace("$", "").replace(".", "").trim());
            flete.setObservacion(jTable4.getValueAt(selectedRow, 5).toString());

            try {
                fleteDAO.eliminarFlete(flete);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(CustomEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

            ((DefaultTableModel) jTable4.getModel()).setNumRows(0);

            Object[] filaTabla4 = new Object[10];
            DefaultTableModel modelTabla4 = (DefaultTableModel) jTable4.getModel();

            ArrayList<Flete> selectFlete = null;
            try {
                selectFlete = fleteDAO.selectFlete(VentanaLogin.tipo, VentanaLogin.nombrex);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            Locale chileLocale = new Locale("es", "CL");
            NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

            selectFlete.stream().forEach((Flete fletex) -> {
                filaTabla4[0] = fletex.getFechaFa();
                filaTabla4[1] = fletex.getNumeroFa();
                filaTabla4[2] = fletex.getVendedor();

                String format = nf.format(Double.valueOf(fletex.getMontoFa()));
                String[] split = format.split(",");

                try {
                    filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla4[3] = "$ " + split[0];
                    }
                }

                format = nf.format(Double.valueOf(fletex.getMontoFaVendedor()));
                split = format.split(",");

                try {
                    filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 2);
                } catch (Exception ex) {
                    try {
                        filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 1);
                    } catch (Exception exx) {
                        filaTabla4[4] = "$ " + split[0];
                    }
                }
                filaTabla4[5] = fletex.getObservacion();
                modelTabla4.addRow(filaTabla4);
            });
        } else {
        }
    }
}

class CustomRenderer1 implements TableCellRenderer {

    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JTextArea textArea;
    JButton jButton1;

    public CustomRenderer1(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        jButton1.setText("Modificar");

        textArea.setColumns(1);
        textArea.setRows(1);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textArea.setText((String) value);
        return jPanel1;
    }
}

class CustomEditor1 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel jPanel1;
    JTextArea textArea;
    JScrollPane jScrollPane1;
    JButton jButton1;

    @Override
    public Object getCellEditorValue() {
        return textArea.getText();
    }

    public CustomEditor1(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        jButton1.setText("Modificar");
        jButton1.addActionListener(this);

        textArea.setColumns(1);
        textArea.setRows(1);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textArea.setText((String) value);
        return jPanel1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            stopCellEditing();

            String codigo = null;
            String costoUnitario = null;
            String folio = null;

            int selectedIndex = Principal.newJFrame.jTabbedPane1.getSelectedIndex();

            if (selectedIndex == 1) {
                int selectedRow = jTable1.getSelectedRow();

                codigo = jTable1.getValueAt(selectedRow, 6).toString();
                costoUnitario = jTable1.getValueAt(selectedRow, 10).toString();
                folio = jTable1.getValueAt(selectedRow, 2).toString();
            } else if (selectedIndex == 2) {
                int selectedRow = jTable6.getSelectedRow();

                codigo = jTable6.getValueAt(selectedRow, 6).toString();
                costoUnitario = jTable6.getValueAt(selectedRow, 11).toString();
                folio = jTable6.getValueAt(selectedRow, 2).toString();
            }

            int count = 0;

            for (int i = 0; i < costoUnitario.length(); i++) {
                if (costoUnitario.charAt(i) == '.') {
                    count++;
                }
            }

            System.out.println("count " + count);
            System.out.println("codigo " + codigo);
            System.out.println("costoUnitario " + costoUnitario);
            System.out.println("folio " + folio);

            if (!costoUnitario.contains("$") && !costoUnitario.contains(",") && count <= 1) {
                try {
                    Double valueOf = Double.valueOf(costoUnitario);

                    int showConfirmDialog = JOptionPane.showConfirmDialog(Principal.newJFrame, "Desea Cambiar el costo?", "?", JOptionPane.YES_NO_OPTION);
                    if (showConfirmDialog == JOptionPane.YES_OPTION) {
                        productoDAO.actualizaProducto(codigo, costoUnitario, folio);

//                        try {
//                            ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
//                        } catch (Exception ex) {
//
//                        }
//                        try {
//                            ((DefaultTableModel) jTable2.getModel()).setNumRows(0);
//                        } catch (Exception ex) {
//
//                        }
//                        try {
//                            ((DefaultTableModel) jTable3.getModel()).setNumRows(0);
//                        } catch (Exception ex) {
//
//                        }
//                        try {
//                            ((DefaultTableModel) jTable4.getModel()).setNumRows(0);
//                        } catch (Exception ex) {
//
//                        }
//                        try {
//                            ((DefaultTableModel) jTable6.getModel()).setNumRows(0);
//                        } catch (Exception ex) {
//
//                        }
//                        try {
//                            cargaTablaLocal();
//                            if (!jLabel4.getText().equals("-")) {
//                                filtraRecuadroUno();
//                            }
//                        } catch (IOException | SQLException ex) {
//                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Tiene $ o ,");
                    JOptionPane.showMessageDialog(null, "Tiene $ o ,", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Tiene $ o ,");
                JOptionPane.showMessageDialog(null, "Tiene $ o ,", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class CustomRenderer2 implements TableCellRenderer {

    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JTextArea textArea;
    JButton jButton1;

    public CustomRenderer2(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        jButton1.setText("Modificar");

        textArea.setColumns(1);
        textArea.setRows(1);

        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            textArea.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textArea.setText((String) value);
        return jPanel1;
    }
}

class CustomEditor2 extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JPanel jPanel1;
    JTextArea textArea;
    JScrollPane jScrollPane1;
    JButton jButton1;

    @Override
    public Object getCellEditorValue() {
        return textArea.getText();
    }

    public CustomEditor2(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        jButton1.setText("Modificar");

        jButton1.addActionListener(this);

        textArea.setColumns(1);
        textArea.setRows(1);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            textArea.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textArea.setText((String) value);
        return jPanel1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres guardar los cambios?", "Quieres guardar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                stopCellEditing();

                int selectedRow = jTable4.getSelectedRow();

                Flete flete = new Flete();
                flete.setFechaFa(jTable4.getValueAt(selectedRow, 0).toString());
                flete.setNumeroFa(jTable4.getValueAt(selectedRow, 1).toString());
                flete.setVendedor(jTable4.getValueAt(selectedRow, 2).toString());
                flete.setMontoFa(jTable4.getValueAt(selectedRow, 3).toString().replace("$", "").replace(".", "").trim());
                flete.setMontoFaVendedor(jTable4.getValueAt(selectedRow, 4).toString().replace("$", "").replace(".", "").trim());
                flete.setObservacion(jTable4.getValueAt(selectedRow, 5).toString());

                try {
                    fleteDAO.actualizaFlete(flete);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(CustomEditor2.class.getName()).log(Level.SEVERE, null, ex);
                }

                ((DefaultTableModel) jTable4.getModel()).setNumRows(0);

                Object[] filaTabla4 = new Object[10];
                DefaultTableModel modelTabla4 = (DefaultTableModel) jTable4.getModel();

                ArrayList<Flete> selectFlete = null;
                try {
                    selectFlete = fleteDAO.selectFlete(VentanaLogin.tipo, VentanaLogin.nombrex);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                Locale chileLocale = new Locale("es", "CL");
                NumberFormat nf = NumberFormat.getNumberInstance(chileLocale);

                selectFlete.stream().forEach((Flete fletex) -> {
                    filaTabla4[0] = fletex.getFechaFa();
                    filaTabla4[1] = fletex.getNumeroFa();
                    filaTabla4[2] = fletex.getVendedor();

                    String format = nf.format(Double.valueOf(fletex.getMontoFa()));
                    String[] split = format.split(",");

                    try {
                        filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla4[3] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla4[3] = "$ " + split[0];
                        }
                    }

                    format = nf.format(Double.valueOf(fletex.getMontoFaVendedor()));
                    split = format.split(",");

                    try {
                        filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 2);
                    } catch (Exception ex) {
                        try {
                            filaTabla4[4] = "$ " + split[0] + "," + split[1].substring(0, 1);
                        } catch (Exception exx) {
                            filaTabla4[4] = "$ " + split[0];
                        }
                    }
                    filaTabla4[5] = fletex.getObservacion();
                    modelTabla4.addRow(filaTabla4);
                });
            }
        } else {
            // no option
        }
    }
}

class CustomRenderer3 implements TableCellRenderer {

    JPanel jPanel1;
    JComboBox jComboBox1;
    JButton jButton1;

    public CustomRenderer3(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jComboBox1.removeAllItems();

        for (int i = 0; i < arrNombresVendedores.size(); i++) {
            String get = arrNombresVendedores.get(i);
            if (!get.equals("")) {
                jComboBox1.addItem(get);
            }
        }

        jButton1.setText("Cambiar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        jComboBox1.setSelectedItem(value);
        return jPanel1;
    }
}

class CustomEditor3 extends AbstractCellEditor implements TableCellEditor {

    JPanel jPanel1;
    JComboBox jComboBox1;
    JButton jButton1;

    @Override
    public Object getCellEditorValue() {
        return jComboBox1.getSelectedItem().toString();
    }

    public CustomEditor3(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(Principal.newJFrame, "Actualizar Vendedor?", "?", JOptionPane.YES_NO_OPTION);
                if (showConfirmDialog == JOptionPane.YES_OPTION) {
                    stopCellEditing();

                    int selectedRow = jTable2.getSelectedRow();

                    String folio = jTable2.getValueAt(selectedRow, 1).toString();
                    String vendedor = jTable2.getValueAt(selectedRow, 4).toString();

                    System.out.println("folioxx " + folio);
                    System.out.println("vendedorxx " + vendedor);

                    facturaDAO.actualizaFactura(folio, vendedor);

//                    try {
//                        ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
//                    } catch (Exception ex) {
//
//                    }
//                    try {
//                        ((DefaultTableModel) jTable2.getModel()).setNumRows(0);
//                    } catch (Exception ex) {
//
//                    }
//                    try {
//                        ((DefaultTableModel) jTable3.getModel()).setNumRows(0);
//                    } catch (Exception ex) {
//
//                    }
//                    try {
//                        ((DefaultTableModel) jTable4.getModel()).setNumRows(0);
//                    } catch (Exception ex) {
//
//                    }
//                    try {
//                        ((DefaultTableModel) jTable6.getModel()).setNumRows(0);
//                    } catch (Exception ex) {
//
//                    }
//                    try {
//                        cargaTablaLocal();
//                        if (!jLabel4.getText().equals("-")) {
//                            filtraRecuadroUno();
//                        }
//                    } catch (IOException | SQLException ex) {
//                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            }
        });

        jComboBox1.removeAllItems();

        for (int i = 0; i < arrNombresVendedores.size(); i++) {
            String get = arrNombresVendedores.get(i);
            if (!get.equals("")) {
                jComboBox1.addItem(get);
            }
        }

        jButton1.setText("Cambiar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        jComboBox1.setSelectedItem(value);
        return jPanel1;
    }
}

class CustomRenderer4 implements TableCellRenderer {

    JPanel jPanel1;
    rojeru_san.componentes.RSDateChooser rSDateChooser1;
    JButton jButton1;

    public CustomRenderer4(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jButton1 = new javax.swing.JButton();

        jButton1.setText("Cambiar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(rSDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            Date parse;
            try {
                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                parse = dateFormat.parse(value.toString());
            } catch (Exception ex) {
                parse = new SimpleDateFormat("yyyy-MM-dd").parse(value.toString());
            }
            rSDateChooser1.setDatoFecha(parse);
            return jPanel1;
        } catch (ParseException ex) {
            Logger.getLogger(CustomRenderer4.class.getName()).log(Level.SEVERE, null, ex);
            return jPanel1;
        }
    }
}

class CustomEditor4 extends AbstractCellEditor implements TableCellEditor {

    JPanel jPanel1;
    rojeru_san.componentes.RSDateChooser rSDateChooser1;
    JButton jButton1;

    @Override
    public Object getCellEditorValue() {
        Date datoFecha = rSDateChooser1.getDatoFecha();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = formatter.format(datoFecha);
        return datoFecha;
    }

    public CustomEditor4(JTable jTable, boolean bool, int num) {
        jPanel1 = new javax.swing.JPanel();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jButton1 = new javax.swing.JButton();

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(Principal.newJFrame, "Actualizar Fecha?", "?", JOptionPane.YES_NO_OPTION);
                if (showConfirmDialog == JOptionPane.YES_OPTION) {
                    if (num == 0) {
                        stopCellEditing();
                        int selectedRow = jTable2.getSelectedRow();
                        System.out.println("selectedRow " + selectedRow);
                        String folio = jTable2.getValueAt(selectedRow, 1).toString();
                        Date datoFecha = rSDateChooser1.getDatoFecha();

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String strDate = dateFormat.format(datoFecha);

                        System.out.println("folioxx " + folio);
                        System.out.println("?? " + strDate);

                        facturaDAO.actualizaFecha(folio, strDate);
                    } else {
                        stopCellEditing();
                        int selectedRow = jTable3.getSelectedRow();
                        System.out.println("selectedRow " + selectedRow);
                        String folioNC = jTable3.getValueAt(selectedRow, 2).toString();
                        Date datoFecha = rSDateChooser1.getDatoFecha();

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String strDate = dateFormat.format(datoFecha);

                        System.out.println("folioxx " + folioNC);
                        System.out.println("?? " + strDate);

                        notaCreditoDAO.actualizaFecha(folioNC, strDate);
                    }
                }
            }
        });

        jButton1.setText("Cambiar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(rSDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jButton1.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        try {
            Date parse;
            try {
                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                parse = dateFormat.parse(value.toString());
            } catch (Exception ex) {
                parse = new SimpleDateFormat("yyyy-MM-dd").parse(value.toString());
            }
            rSDateChooser1.setDatoFecha(parse);
            return jPanel1;
        } catch (ParseException ex) {
            Logger.getLogger(CustomRenderer4.class.getName()).log(Level.SEVERE, null, ex);
            return jPanel1;
        }
    }
}

class CustomRenderer5 extends JLabel implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        String s = "";

        String valueOf = String.valueOf(value).replace("$", "").replace(".", "").replace(",", "").replace("%", "").replace("?", "");
        try {
            Double valueOf1 = Double.valueOf(valueOf);
            if (valueOf1 < 0) {
                c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                ((JLabel) c).setForeground(Color.red);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
            }
        } catch (Exception ex) {
            c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
        }
        return c;
    }
}

class CustomRenderer6 implements TableCellRenderer {

    JPanel jPanel1;
    JCheckBox jCheckBox1;

    public CustomRenderer6(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();

        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jCheckBox1.setEnabled(false);
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            if (value.toString().trim().equals("true")) {
                jCheckBox1.setSelected(true);
            } else {
                jCheckBox1.setSelected(false);
            }
        } catch (Exception ex) {
            jCheckBox1.setSelected(false);
        }
        return jPanel1;
    }
}

class CustomEditor6 extends AbstractCellEditor implements TableCellEditor {

    JPanel jPanel1;
    JCheckBox jCheckBox1;

    public Object getCellEditorValue() {
        return jCheckBox1.isSelected();
    }

    public CustomEditor6(JTable jTable, boolean bool) {
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();

        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = jTable2.getSelectedRow();
                String folio = jTable2.getValueAt(selectedRow, 1).toString();
                jTable2.setValueAt(jCheckBox1.isSelected(), selectedRow, 11);

                System.out.println("folio " + jCheckBox1.isSelected());

                facturaDAO.actualizaPagada(folio, String.valueOf(jCheckBox1.isSelected()));
            }
        });

        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        if (bool || VentanaLogin.nombrex.equals("ESPINV") || VentanaLogin.nombrex.equals("ROJICD")) {
            jCheckBox1.setEnabled(false);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        try {
            if (value.toString().trim().equals("true")) {
                jCheckBox1.setSelected(true);
            } else {
                jCheckBox1.setSelected(false);
            }
        } catch (Exception ex) {
            jCheckBox1.setSelected(false);
        }
        return jPanel1;
    }
}

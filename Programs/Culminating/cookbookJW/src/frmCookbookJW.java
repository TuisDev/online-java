import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.image.BufferedImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jijwa
 */
public class frmCookbookJW extends javax.swing.JFrame {

    // Global Constants
    String dbPath = "/cookbook.csv";
    
    // Global Variables
    String imagePath = "";
    int buttonIndex;
    int recipeIndex = 0;
    javax.swing.JPanel buttonPanel;
    
    String [] names = {};
    String [] imagePaths = {};
    String [] ingredientLists = {};
    String [] directionLists = {};
    
    // GUI components
    private javax.swing.GroupLayout cookbookLayout;
    
    private javax.swing.JLayeredPane [] lpnRecipes = {};
    private javax.swing.JPanel [] pnlEditRecipes = {};
    private javax.swing.JButton [] btnEditRecipes = {};
    private javax.swing.JPanel [] pnlRecipes = {};
    private javax.swing.JLabel [] lblRecipeImages = {};
    private javax.swing.JLabel [] lblRecipeTitles = {};
    
    // Methods
    
    /* append
    
    The following methods all take an array, and add a new element on to the end of it.

    Parameters: (String [], String); (JLabel [], JLabel); (JPanel [], JPanel); (JLayeredPane [], JLayeredPane); or (JButton [], JButton)

    Returns: String []; JLabel []; JPanel []; JLayeredPane []; or JButton []
    */
    public static String [] append (String [] array, String newElement) {
        String [] temp = new String [array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        
        temp[array.length] = newElement;
        array = temp;
        return array;
    }
    public static javax.swing.JLabel [] append (javax.swing.JLabel [] array, javax.swing.JLabel newElement) {
        javax.swing.JLabel [] temp = new javax.swing.JLabel [array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[array.length] = newElement;
        array = temp;

        return array;
    }
    public static javax.swing.JPanel [] append (javax.swing.JPanel [] array, javax.swing.JPanel newElement) {
        javax.swing.JPanel [] temp = new javax.swing.JPanel [array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[array.length] = newElement;
        array = temp;

        return array;
    }
    public static javax.swing.JLayeredPane [] append (javax.swing.JLayeredPane [] array, javax.swing.JLayeredPane newElement) {
        javax.swing.JLayeredPane [] temp = new javax.swing.JLayeredPane [array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[array.length] = newElement;
        array = temp;

        return array;
    }
    public static javax.swing.JButton [] append (javax.swing.JButton [] array, javax.swing.JButton newElement) {
        javax.swing.JButton [] temp = new javax.swing.JButton [array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[array.length] = newElement;
        array = temp;

        return array;
    }
    /* remove
    
    This method removes an element from an array
    
    Parameters: String [], int
    
    Returns: String []
    */
    public static String [] remove (String [] array, int index) {
        if (array.length > 0) {
            String [] temp = new String [array.length - 1];
            for (int i = 0; i < array.length; i ++) {
                if (i < index) {
                    temp[i] = array[i];
                } else if (i > index) {
                    temp[i - 1] = array[i];
                }
            }
            
            array = temp;
            return array;
        } else {
            return new String [0];
        }
    }

    /*indexOf
    
    This method find the index of a element within an array

    Parameters: String [], String

    Returns: int
     */
    public static int indexOf(String [] array, String object) {
        // Variables
        int i = 0;

        // Iterate over every element in the array, until you find one that matches the input
        for (String element : array) {
            if (element.equals(object)) {
                return i;
            }
            i ++;
        }
        return 0;
    }

    /* erasePanel

    This method clears both the search results and cookbook results panel

    Parameters: none

    Returns: none
     */
    public void erasePanel() {
        for (int i = 0; i < lpnRecipes.length; i ++) {
            pnlCookbookResults.remove(lpnRecipes[i]);
        }
        
        cookbookLayout = new javax.swing.GroupLayout(pnlCookbookResults);
        pnlCookbookResults.setLayout(cookbookLayout);
        pnlCookbookResults.revalidate();
        pnlCookbookResults.repaint();
        revalidate();
        repaint();
        
        for (int i = 0; i < lpnRecipes.length; i ++) {
            pnlSearchResults.remove(lpnRecipes[i]);
        }
        
        cookbookLayout = new javax.swing.GroupLayout(pnlSearchResults);
        pnlSearchResults.setLayout(cookbookLayout);
        pnlSearchResults.revalidate();
        pnlSearchResults.repaint();
        revalidate();
        repaint();
    }
    
    /* readDb
    
    These methods read data from the database
    
    Parameters: either none or String, String, String, STring
    
    Returns: none
    */
    public void readDb() {
        // Variables
        String line;
        String [] values;
        names = new String [0];
        imagePaths = new String [0];
        ingredientLists = new String [0];
        directionLists = new String [0];
        
        try {
            FileReader csvFile = new FileReader("src" + dbPath);
            BufferedReader csvReader = new BufferedReader(csvFile);

                while ((line = csvReader.readLine()) != null) {   
                    values = line.split(",");
                    names = append(names, values[0]);
                    imagePaths = append(imagePaths, values[1]);
                    ingredientLists = append(ingredientLists, values[2]);
                    directionLists = append(directionLists, values[3]);
                }
            
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Database not found!");
        }
    }
    public void readDb(String name, String image, String ingredientList, String directionList) {
        // Variables
        String line;
        String [] values;
        names = new String [1];
        imagePaths = new String [1];
        ingredientLists = new String [1];
        directionLists = new String [1];
        
        names[0] = name;
        imagePaths[0] = image;
        ingredientLists[0] = ingredientList;
        directionLists[0] = directionList;
        
        try {
            FileReader csvFile = new FileReader("src" + dbPath);
            BufferedReader csvReader = new BufferedReader(csvFile);

                while ((line = csvReader.readLine()) != null) {   
                    values = line.split(",");
                    names = append(names, values[0]);
                    imagePaths = append(imagePaths, values[1]);
                    ingredientLists = append(ingredientLists, values[2]);
                    directionLists = append(directionLists, values[3]);
                }

            csvReader.close();
        } catch (IOException e) {
            System.out.println("Database not found!");
        }
    }
    
    /* drawRecipes
    
    This method draws the recipe cards onto a given JPanel
    
    Parameters: JPanel, int
    
    Returns: none
    */
    public void drawRecipes(javax.swing.JPanel panel, int offset) {
        // Variables
        cookbookLayout = new javax.swing.GroupLayout(panel);

        // Erase the Panel
        erasePanel();
        
        
        for (int i = 0; i < names.length; i ++) {
            int j = i; // Makes the event listeners happy
            
            cookbookLayout = new javax.swing.GroupLayout(panel);
            

            // Create new element
            if (i == 0) {
                lpnRecipes = new javax.swing.JLayeredPane [0];
                pnlEditRecipes = new javax.swing.JPanel [0];
                btnEditRecipes = new javax.swing.JButton [0];
                pnlRecipes = new javax.swing.JPanel [0];
                lblRecipeImages = new javax.swing.JLabel [0];
                lblRecipeTitles = new javax.swing.JLabel [0];
            }
            lpnRecipes = append(lpnRecipes, new javax.swing.JLayeredPane());
            pnlEditRecipes = append(pnlEditRecipes, new javax.swing.JPanel());
            btnEditRecipes = append(btnEditRecipes, new javax.swing.JButton());
            pnlRecipes = append(pnlRecipes, new javax.swing.JPanel());
            lblRecipeImages = append(lblRecipeImages, new javax.swing.JLabel());
            lblRecipeTitles = append(lblRecipeTitles, new javax.swing.JLabel());


            // Format components
            lpnRecipes[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

            pnlEditRecipes[i].setOpaque(false);

            btnEditRecipes[i].setFont(new java.awt.Font("Arial Black", 0, 12));
            btnEditRecipes[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png")));
            btnEditRecipes[i].setBorder(null);
            btnEditRecipes[i].setHideActionText(true);
            btnEditRecipes[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnEditRecipesActionPerformed(evt, j, panel);
                }
            });

            pnlRecipes[i].setBackground(new java.awt.Color(255, 255, 255));
            pnlRecipes[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    pnlRecipesMouseClicked(evt, j);
                }
            });

            if (!imagePaths[i].isBlank()) {
                lblRecipeImages[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePaths[i])));
            }
            lblRecipeTitles[i].setFont(new java.awt.Font("Gill Sans MT", 0, 18));
            lblRecipeTitles[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblRecipeTitles[i].setText(names[i]);
            lblRecipeTitles[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);


            // Align components
            javax.swing.GroupLayout pnlEditRecipeLayout = new javax.swing.GroupLayout(pnlEditRecipes[i]);
            pnlEditRecipes[i].setLayout(pnlEditRecipeLayout);
            pnlEditRecipeLayout.setHorizontalGroup(
                pnlEditRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditRecipeLayout.createSequentialGroup()
                    .addGap(0, 89, Short.MAX_VALUE)
                    .addComponent(btnEditRecipes[i]))
            );
            pnlEditRecipeLayout.setVerticalGroup(
                pnlEditRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEditRecipeLayout.createSequentialGroup()
                    .addComponent(btnEditRecipes[i])
                    .addGap(0, 90, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout pnlRecipeLayout = new javax.swing.GroupLayout(pnlRecipes[i]);
            pnlRecipes[i].setLayout(pnlRecipeLayout);
            pnlRecipeLayout.setHorizontalGroup(
                pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecipeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblRecipeTitles[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(pnlRecipeLayout.createSequentialGroup()
                    .addComponent(lblRecipeImages[i])
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            pnlRecipeLayout.setVerticalGroup(
                pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRecipeLayout.createSequentialGroup()
                    .addComponent(lblRecipeImages[i], javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblRecipeTitles[i], javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addContainerGap())
            );

            lpnRecipes[i].setLayer(pnlEditRecipes[i], javax.swing.JLayeredPane.POPUP_LAYER);
            lpnRecipes[i].setLayer(pnlRecipes[i], javax.swing.JLayeredPane.DEFAULT_LAYER);

            javax.swing.GroupLayout lpnRecipeLayout = new javax.swing.GroupLayout(lpnRecipes[i]);
            lpnRecipes[i].setLayout(lpnRecipeLayout);
            lpnRecipeLayout.setHorizontalGroup(
                lpnRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlRecipes[i], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lpnRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lpnRecipeLayout.createSequentialGroup()
                        .addContainerGap(141, Short.MAX_VALUE)
                        .addComponent(pnlEditRecipes[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()))
            );
            lpnRecipeLayout.setVerticalGroup(
                lpnRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlRecipes[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(lpnRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lpnRecipeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlEditRecipes[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(154, Short.MAX_VALUE)))
            );

            // Place the card in it's proper place
            panel.setLayout(cookbookLayout);
            cookbookLayout.setHorizontalGroup(
                cookbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cookbookLayout.createSequentialGroup()
                    .addGap(((i + offset) * 310) % 1240 + 25)
                    .addComponent(lpnRecipes[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap((3 - (i + offset) % 4) * 320 + 25, Short.MAX_VALUE))
            );
            cookbookLayout.setVerticalGroup(
                cookbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cookbookLayout.createSequentialGroup()
                    .addGap(((i + offset) / 4) * 334 + 25)
                    .addComponent(lpnRecipes[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
            );
//            
//            panel.repaint();
            revalidate();
        }
    }
    
    /**
     * Creates new form frmCookbookJW
     */
    public frmCookbookJW() {
        initComponents();
        pnlNewRecipeLayer.setVisible(false);
        readDb();
        drawRecipes(pnlSearchResults, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchUpload = new javax.swing.JFileChooser();
        pmnEdit = new javax.swing.JPopupMenu();
        mnuEdit = new javax.swing.JMenuItem();
        mnuDelete = new javax.swing.JMenuItem();
        lpnMain = new javax.swing.JLayeredPane();
        pnlSearchLayer = new javax.swing.JPanel();
        pnlSearch = new javax.swing.JPanel();
        pnlSearchHeader = new javax.swing.JPanel();
        pnlSearchBox = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearchIcon = new javax.swing.JLabel();
        scpSearchResults = new javax.swing.JScrollPane();
        pnlSearchResults = new javax.swing.JPanel();
        pnlCookbookLayer = new javax.swing.JLayeredPane();
        pnlCookbookHeader = new javax.swing.JPanel();
        lblCookbook = new javax.swing.JLabel();
        scpCookbookResults = new javax.swing.JScrollPane();
        pnlCookbookResults = new javax.swing.JPanel();
        pnlAddRecipe = new javax.swing.JPanel();
        lblAddRecipe = new javax.swing.JLabel();
        pnlNewRecipeLayer = new javax.swing.JPanel();
        pnlNewRecipe = new javax.swing.JPanel();
        scpNewDirections = new javax.swing.JScrollPane();
        pnlNewDirections = new javax.swing.JPanel();
        lblDirectionsInst = new javax.swing.JLabel();
        txtNewDirections = new javax.swing.JTextArea();
        pnlNewIngredientsBox = new javax.swing.JPanel();
        scpNewIngredients = new javax.swing.JScrollPane();
        pnlNewIngredients = new javax.swing.JPanel();
        txtNewIngredients = new javax.swing.JTextArea();
        lblIngredientsInst = new javax.swing.JLabel();
        lblNewIngredients = new javax.swing.JLabel();
        lblNewDirections = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCancel = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblDone = new javax.swing.JLabel();
        pnlSidebar = new javax.swing.JPanel();
        lblWatsonCookbooks = new javax.swing.JLabel();
        lblSearchSidebar = new javax.swing.JLabel();
        lblRecipeSidebar = new javax.swing.JLabel();
        lblCookbookSidebar = new javax.swing.JLabel();
        pnlRecipeLayer = new javax.swing.JPanel();
        pnlRecipe = new javax.swing.JPanel();
        pnlRecipeHeader = new javax.swing.JPanel();
        lblRecipeTitle = new javax.swing.JLabel();
        lblRecipeName = new javax.swing.JLabel();
        scpDirections = new javax.swing.JScrollPane();
        pnlDirections = new javax.swing.JPanel();
        lstDirections = new javax.swing.JList<>();
        lblDirections = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        pnlIngredientsBox = new javax.swing.JPanel();
        scpIngredients = new javax.swing.JScrollPane();
        pnlIngredients = new javax.swing.JPanel();
        lstIngredients = new javax.swing.JList<>();
        lblIngredients = new javax.swing.JLabel();

        fchUpload.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        fchUpload.setApproveButtonText("Upload");
        fchUpload.setApproveButtonToolTipText("Upload an Image");
        fchUpload.setBackground(new java.awt.Color(255, 255, 255));
        fchUpload.setDialogTitle("Upload an Image");
        fchUpload.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fchUpload.setMinimumSize(new java.awt.Dimension(588, 328));

        mnuEdit.setText("Edit");
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        pmnEdit.add(mnuEdit);

        mnuDelete.setText("Delete");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        pmnEdit.add(mnuDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lpnMain.setOpaque(true);

        pnlSearchLayer.setOpaque(false);

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));

        pnlSearchHeader.setBackground(new java.awt.Color(255, 85, 85));

        pnlSearchBox.setBackground(new java.awt.Color(255, 255, 255));
        pnlSearchBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtSearch.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lblSearchIcon.setBackground(new java.awt.Color(255, 255, 255));
        lblSearchIcon.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        lblSearchIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bigSearch.png"))); // NOI18N
        lblSearchIcon.setOpaque(true);

        javax.swing.GroupLayout pnlSearchBoxLayout = new javax.swing.GroupLayout(pnlSearchBox);
        pnlSearchBox.setLayout(pnlSearchBoxLayout);
        pnlSearchBoxLayout.setHorizontalGroup(
            pnlSearchBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSearchBoxLayout.setVerticalGroup(
            pnlSearchBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBoxLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlSearchBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(lblSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlSearchHeaderLayout = new javax.swing.GroupLayout(pnlSearchHeader);
        pnlSearchHeader.setLayout(pnlSearchHeaderLayout);
        pnlSearchHeaderLayout.setHorizontalGroup(
            pnlSearchHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchHeaderLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(pnlSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchHeaderLayout.setVerticalGroup(
            pnlSearchHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        scpSearchResults.setBorder(null);
        scpSearchResults.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlSearchResults.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlSearchResultsLayout = new javax.swing.GroupLayout(pnlSearchResults);
        pnlSearchResults.setLayout(pnlSearchResultsLayout);
        pnlSearchResultsLayout.setHorizontalGroup(
            pnlSearchResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1326, Short.MAX_VALUE)
        );
        pnlSearchResultsLayout.setVerticalGroup(
            pnlSearchResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );

        scpSearchResults.setViewportView(pnlSearchResults);

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scpSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                    .addComponent(pnlSearchHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(pnlSearchHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scpSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSearchLayerLayout = new javax.swing.GroupLayout(pnlSearchLayer);
        pnlSearchLayer.setLayout(pnlSearchLayerLayout);
        pnlSearchLayerLayout.setHorizontalGroup(
            pnlSearchLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchLayerLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlSearchLayerLayout.setVerticalGroup(
            pnlSearchLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlCookbookLayer.setBackground(new java.awt.Color(255, 255, 255));
        pnlCookbookLayer.setOpaque(true);

        pnlCookbookHeader.setBackground(new java.awt.Color(255, 85, 85));

        lblCookbook.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        lblCookbook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCookbook.setText("Cookbook");

        javax.swing.GroupLayout pnlCookbookHeaderLayout = new javax.swing.GroupLayout(pnlCookbookHeader);
        pnlCookbookHeader.setLayout(pnlCookbookHeaderLayout);
        pnlCookbookHeaderLayout.setHorizontalGroup(
            pnlCookbookHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookbookHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCookbook, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE))
        );
        pnlCookbookHeaderLayout.setVerticalGroup(
            pnlCookbookHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookbookHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblCookbook)
                .addGap(49, 49, 49))
        );

        scpCookbookResults.setBackground(new java.awt.Color(255, 255, 255));
        scpCookbookResults.setBorder(null);
        scpCookbookResults.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpCookbookResults.setPreferredSize(new java.awt.Dimension(1250, 744));

        pnlCookbookResults.setBackground(new java.awt.Color(255, 255, 255));
        pnlCookbookResults.setDoubleBuffered(false);

        pnlAddRecipe.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddRecipe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblAddRecipe.setFont(new java.awt.Font("Franklin Gothic Book", 0, 200)); // NOI18N
        lblAddRecipe.setForeground(new java.awt.Color(221, 17, 17));
        lblAddRecipe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddRecipe.setText("+");
        lblAddRecipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddRecipeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAddRecipeLayout = new javax.swing.GroupLayout(pnlAddRecipe);
        pnlAddRecipe.setLayout(pnlAddRecipeLayout);
        pnlAddRecipeLayout.setHorizontalGroup(
            pnlAddRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAddRecipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        pnlAddRecipeLayout.setVerticalGroup(
            pnlAddRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAddRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlCookbookResultsLayout = new javax.swing.GroupLayout(pnlCookbookResults);
        pnlCookbookResults.setLayout(pnlCookbookResultsLayout);
        pnlCookbookResultsLayout.setHorizontalGroup(
            pnlCookbookResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookbookResultsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlAddRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(945, Short.MAX_VALUE))
        );
        pnlCookbookResultsLayout.setVerticalGroup(
            pnlCookbookResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookbookResultsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlAddRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        scpCookbookResults.setViewportView(pnlCookbookResults);

        pnlNewRecipeLayer.setOpaque(false);

        pnlNewRecipe.setBackground(new java.awt.Color(255, 255, 255));

        scpNewDirections.setBorder(null);
        scpNewDirections.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlNewDirections.setBackground(new java.awt.Color(255, 255, 255));

        lblDirectionsInst.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblDirectionsInst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDirectionsInst.setText("Enter the directions below, one direction per line");

        txtNewDirections.setColumns(20);
        txtNewDirections.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtNewDirections.setRows(10);
        txtNewDirections.setBorder(null);

        javax.swing.GroupLayout pnlNewDirectionsLayout = new javax.swing.GroupLayout(pnlNewDirections);
        pnlNewDirections.setLayout(pnlNewDirectionsLayout);
        pnlNewDirectionsLayout.setHorizontalGroup(
            pnlNewDirectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDirectionsInst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewDirectionsLayout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(txtNewDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNewDirectionsLayout.setVerticalGroup(
            pnlNewDirectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewDirectionsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblDirectionsInst)
                .addGap(10, 10, 10)
                .addComponent(txtNewDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        scpNewDirections.setViewportView(pnlNewDirections);

        pnlNewIngredientsBox.setBackground(new java.awt.Color(255, 170, 170));
        pnlNewIngredientsBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        scpNewIngredients.setBorder(null);
        scpNewIngredients.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlNewIngredients.setBackground(new java.awt.Color(255, 255, 255));

        txtNewIngredients.setColumns(20);
        txtNewIngredients.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtNewIngredients.setRows(10);
        txtNewIngredients.setToolTipText("");
        txtNewIngredients.setBorder(null);

        lblIngredientsInst.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblIngredientsInst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIngredientsInst.setText("Enter the ingredients below, one ingredient per line");

        javax.swing.GroupLayout pnlNewIngredientsLayout = new javax.swing.GroupLayout(pnlNewIngredients);
        pnlNewIngredients.setLayout(pnlNewIngredientsLayout);
        pnlNewIngredientsLayout.setHorizontalGroup(
            pnlNewIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewIngredientsLayout.createSequentialGroup()
                .addGroup(pnlNewIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNewIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIngredientsInst, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlNewIngredientsLayout.setVerticalGroup(
            pnlNewIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewIngredientsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIngredientsInst)
                .addGap(10, 10, 10)
                .addComponent(txtNewIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        scpNewIngredients.setViewportView(pnlNewIngredients);

        lblNewIngredients.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lblNewIngredients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewIngredients.setText("Ingredients");

        javax.swing.GroupLayout pnlNewIngredientsBoxLayout = new javax.swing.GroupLayout(pnlNewIngredientsBox);
        pnlNewIngredientsBox.setLayout(pnlNewIngredientsBoxLayout);
        pnlNewIngredientsBoxLayout.setHorizontalGroup(
            pnlNewIngredientsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpNewIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addComponent(lblNewIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNewIngredientsBoxLayout.setVerticalGroup(
            pnlNewIngredientsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewIngredientsBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpNewIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        lblNewDirections.setBackground(new java.awt.Color(255, 255, 255));
        lblNewDirections.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lblNewDirections.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewDirections.setText("Directions");

        txtName.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Name:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Gill Sans MT", 0, 14))); // NOI18N

        lblCancel.setBackground(new java.awt.Color(255, 170, 170));
        lblCancel.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancel.setText("Cancel");
        lblCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 170, 170), 1, true));
        lblCancel.setOpaque(true);
        lblCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelMouseClicked(evt);
            }
        });

        lblImage.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Image:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Gill Sans MT", 0, 14))); // NOI18N
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        lblDone.setBackground(new java.awt.Color(255, 170, 170));
        lblDone.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblDone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDone.setText("Done");
        lblDone.setOpaque(true);
        lblDone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNewRecipeLayout = new javax.swing.GroupLayout(pnlNewRecipe);
        pnlNewRecipe.setLayout(pnlNewRecipeLayout);
        pnlNewRecipeLayout.setHorizontalGroup(
            pnlNewRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRecipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lblDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNewIngredientsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNewRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNewDirections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpNewDirections, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)))
        );
        pnlNewRecipeLayout.setVerticalGroup(
            pnlNewRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewRecipeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 359, Short.MAX_VALUE))
            .addComponent(pnlNewIngredientsBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlNewRecipeLayout.createSequentialGroup()
                .addComponent(lblNewDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpNewDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNewRecipeLayerLayout = new javax.swing.GroupLayout(pnlNewRecipeLayer);
        pnlNewRecipeLayer.setLayout(pnlNewRecipeLayerLayout);
        pnlNewRecipeLayerLayout.setHorizontalGroup(
            pnlNewRecipeLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlNewRecipeLayerLayout.setVerticalGroup(
            pnlNewRecipeLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewRecipeLayerLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(pnlNewRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCookbookLayer.setLayer(pnlCookbookHeader, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlCookbookLayer.setLayer(scpCookbookResults, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlCookbookLayer.setLayer(pnlNewRecipeLayer, 2);

        javax.swing.GroupLayout pnlCookbookLayerLayout = new javax.swing.GroupLayout(pnlCookbookLayer);
        pnlCookbookLayer.setLayout(pnlCookbookLayerLayout);
        pnlCookbookLayerLayout.setHorizontalGroup(
            pnlCookbookLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCookbookHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scpCookbookResults, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCookbookLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCookbookLayerLayout.createSequentialGroup()
                    .addComponent(pnlNewRecipeLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlCookbookLayerLayout.setVerticalGroup(
            pnlCookbookLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCookbookLayerLayout.createSequentialGroup()
                .addComponent(pnlCookbookHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scpCookbookResults, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(pnlCookbookLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlNewRecipeLayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSidebar.setBackground(new java.awt.Color(221, 17, 17));
        pnlSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSidebarMouseClicked(evt);
            }
        });

        lblWatsonCookbooks.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        lblWatsonCookbooks.setForeground(new java.awt.Color(255, 255, 255));
        lblWatsonCookbooks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWatsonCookbooks.setText("Watson Cookbooks");

        lblSearchSidebar.setBackground(new java.awt.Color(255, 255, 255));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        lblSearchSidebar.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchSelected.png"))); // NOI18N
        lblSearchSidebar.setText("Search");
        lblSearchSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchSidebarMouseClicked(evt);
            }
        });

        lblRecipeSidebar.setBackground(new java.awt.Color(255, 255, 255));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblRecipeSidebar.setForeground(new java.awt.Color(255, 255, 255));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipe.png"))); // NOI18N
        lblRecipeSidebar.setText("Recipe");
        lblRecipeSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecipeSidebarMouseClicked(evt);
            }
        });

        lblCookbookSidebar.setBackground(new java.awt.Color(255, 255, 255));
        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblCookbookSidebar.setForeground(new java.awt.Color(255, 255, 255));
        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbook.png"))); // NOI18N
        lblCookbookSidebar.setText("Cookbook");
        lblCookbookSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCookbookSidebarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWatsonCookbooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidebarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRecipeSidebar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCookbookSidebar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(lblSearchSidebar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWatsonCookbooks)
                .addGap(44, 44, 44)
                .addComponent(lblSearchSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblCookbookSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblRecipeSidebar)
                .addContainerGap(543, Short.MAX_VALUE))
        );

        pnlRecipeLayer.setOpaque(false);

        pnlRecipe.setBackground(new java.awt.Color(255, 255, 255));

        pnlRecipeHeader.setBackground(new java.awt.Color(255, 85, 85));

        lblRecipeTitle.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        lblRecipeTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecipeTitle.setText("Recipe");

        lblRecipeName.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblRecipeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlRecipeHeaderLayout = new javax.swing.GroupLayout(pnlRecipeHeader);
        pnlRecipeHeader.setLayout(pnlRecipeHeaderLayout);
        pnlRecipeHeaderLayout.setHorizontalGroup(
            pnlRecipeHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRecipeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRecipeHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRecipeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlRecipeHeaderLayout.setVerticalGroup(
            pnlRecipeHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblRecipeTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecipeName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        scpDirections.setBackground(new java.awt.Color(255, 255, 255));
        scpDirections.setBorder(null);
        scpDirections.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlDirections.setBackground(new java.awt.Color(255, 255, 255));

        lstDirections.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDirectionsLayout = new javax.swing.GroupLayout(pnlDirections);
        pnlDirections.setLayout(pnlDirectionsLayout);
        pnlDirectionsLayout.setHorizontalGroup(
            pnlDirectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDirectionsLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lstDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDirectionsLayout.setVerticalGroup(
            pnlDirectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDirectionsLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lstDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scpDirections.setViewportView(pnlDirections);

        lblDirections.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lblDirections.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDirections.setText("Directions");

        btnEdit.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEdit.setBorder(null);
        btnEdit.setHideActionText(true);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        pnlIngredientsBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        scpIngredients.setBorder(null);
        scpIngredients.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlIngredients.setBackground(new java.awt.Color(255, 255, 255));

        lstIngredients.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlIngredientsLayout = new javax.swing.GroupLayout(pnlIngredients);
        pnlIngredients.setLayout(pnlIngredientsLayout);
        pnlIngredientsLayout.setHorizontalGroup(
            pnlIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngredientsLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lstIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlIngredientsLayout.setVerticalGroup(
            pnlIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngredientsLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lstIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scpIngredients.setViewportView(pnlIngredients);

        lblIngredients.setBackground(new java.awt.Color(255, 170, 170));
        lblIngredients.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lblIngredients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIngredients.setText("Ingredients");
        lblIngredients.setOpaque(true);

        javax.swing.GroupLayout pnlIngredientsBoxLayout = new javax.swing.GroupLayout(pnlIngredientsBox);
        pnlIngredientsBox.setLayout(pnlIngredientsBoxLayout);
        pnlIngredientsBoxLayout.setHorizontalGroup(
            pnlIngredientsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientsBoxLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlIngredientsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(lblIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnlIngredientsBoxLayout.setVerticalGroup(
            pnlIngredientsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientsBoxLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scpIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlRecipeLayout = new javax.swing.GroupLayout(pnlRecipe);
        pnlRecipe.setLayout(pnlRecipeLayout);
        pnlRecipeLayout.setHorizontalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addComponent(pnlIngredientsBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDirections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpDirections)))
            .addComponent(pnlRecipeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecipeLayout.createSequentialGroup()
                    .addContainerGap(1214, Short.MAX_VALUE)
                    .addComponent(btnEdit)
                    .addContainerGap()))
        );
        pnlRecipeLayout.setVerticalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addComponent(pnlRecipeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblDirections, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scpDirections, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                    .addComponent(pnlIngredientsBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRecipeLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(btnEdit)
                    .addContainerGap(573, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlRecipeLayerLayout = new javax.swing.GroupLayout(pnlRecipeLayer);
        pnlRecipeLayer.setLayout(pnlRecipeLayerLayout);
        pnlRecipeLayerLayout.setHorizontalGroup(
            pnlRecipeLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecipeLayerLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(pnlRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRecipeLayerLayout.setVerticalGroup(
            pnlRecipeLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lpnMain.setLayer(pnlSearchLayer, 3);
        lpnMain.setLayer(pnlCookbookLayer, 1);
        lpnMain.setLayer(pnlSidebar, 2);
        lpnMain.setLayer(pnlRecipeLayer, 2);

        javax.swing.GroupLayout lpnMainLayout = new javax.swing.GroupLayout(lpnMain);
        lpnMain.setLayout(lpnMainLayout);
        lpnMainLayout.setHorizontalGroup(
            lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpnMainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCookbookLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpnMainLayout.createSequentialGroup()
                    .addComponent(pnlRecipeLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpnMainLayout.createSequentialGroup()
                    .addComponent(pnlSearchLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        lpnMainLayout.setVerticalGroup(
            lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCookbookLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlRecipeLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(lpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpnMainLayout.createSequentialGroup()
                    .addComponent(pnlSearchLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lpnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lpnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlRecipesMouseClicked(java.awt.event.MouseEvent evt, int index) {
        //Variables
        String regex = "\u222B";
        recipeIndex = index;
        
        // Read from the database
        readDb();
        
        // Output the recipe name, ingredients and directions
        lblRecipeName.setText(names[index]);
        lstIngredients.setListData(ingredientLists[index].split(regex));
        lstDirections.setListData(directionLists[index].split(regex));

        // Bold the recipe icon and text
        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbook.png")));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipeSelected.png")));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));
        
        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        
        // Hide the cookbook and search layer, show the recipe layer
        pnlCookbookLayer.setVisible(false);
        pnlRecipeLayer.setVisible(true);
        pnlSearchLayer.setVisible(false);
        
    }
    
    private void btnEditRecipesActionPerformed(java.awt.event.ActionEvent evt, int index, javax.swing.JPanel panel) {     
        // Variables   
        int x = java.awt.MouseInfo.getPointerInfo().getLocation().x - panel.getLocationOnScreen().x;
        int y = java.awt.MouseInfo.getPointerInfo().getLocation().y - panel.getLocationOnScreen().y;
        buttonIndex = index;
        buttonPanel = panel;

        // Show the popup menu
        pmnEdit.show(panel, x, y);
    }
    
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // Variables
        String [] resultantNames = {};
        String [] resultantImages = {};
        String [] resultantIngredients = {};
        String [] resultantDirections = {};
        String searchTerm = txtSearch.getText();
        
        // Read from the databse
        readDb();

        // Get all of the recipes that fit the search term
        for (int i = 0; i < names.length; i ++) {
            if (names[i].toLowerCase().contains(searchTerm.toLowerCase())) {
                resultantNames = append(resultantNames, names[i]);
                resultantImages = append(resultantImages, imagePaths[i]);
                resultantIngredients = append(resultantIngredients, ingredientLists[i]);
                resultantDirections = append(resultantDirections, directionLists[i]);
            }
        }

        names = resultantNames;
        imagePaths = resultantImages;
        ingredientLists = resultantIngredients;
        directionLists = resultantDirections;

        // Display the recipes
        drawRecipes(pnlSearchResults, 0);

        // Read from the database
        readDb();

        
        for (int i = 0; i < resultantNames.length; i ++) {
            int index = indexOf(names, resultantNames[i]);

            btnEditRecipes[i].removeActionListener(btnEditRecipes[i].getActionListeners()[0]);
            btnEditRecipes[i].addActionListener((java.awt.event.ActionEvent evt1) -> {
               btnEditRecipesActionPerformed(evt1, index, pnlSearchResults);
            });
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lblAddRecipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRecipeMouseClicked
        // TODO add your handling code here:
        lblDone.setText("Done");
        pnlNewRecipeLayer.setVisible(true);
        
    }//GEN-LAST:event_lblAddRecipeMouseClicked

    private void lblCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseClicked
        // TODO add your handling code here:
        txtName.setText("");
        if (!imagePath.isBlank() && lblDone.getText().equals("Done")) {
            File oldImage = new File("src" + imagePath);
            oldImage.delete();
        }
        lblImage.setIcon(null);
        imagePath = "";
        txtNewIngredients.setText("");
        txtNewDirections.setText("");
        
        
        
        pnlNewRecipeLayer.setVisible(false);
        
        readDb();
        drawRecipes(pnlCookbookResults, 1);
    }//GEN-LAST:event_lblCancelMouseClicked

    private void lblDoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoneMouseClicked
        // TODO add your handling code here:
        
        // Variables
        String name = txtName.getText();
        String image = imagePath;
        String ingredientList = txtNewIngredients.getText().replace("\n", "\u222B");
        String directionList = txtNewDirections.getText().replace("\n", "\u222B");
       
        // Replace empty variables with null
        if (name.equals("")) {
            name = " ";
        }
        if (image.equals("")) {
            image = " ";
        }
        if (ingredientList.equals("")) {
            ingredientList = " ";
        }
        if (directionList.equals("")) {
            directionList = " ";
        }
        
        try {
            if (lblDone.getText().equals("Done")) {
                readDb(name, image, ingredientList, directionList);
            } else {
                readDb();
                names[buttonIndex] = name;
                imagePaths[buttonIndex] = image;
                ingredientLists[buttonIndex] = ingredientList;
                directionLists[buttonIndex] = directionList;
            }
            FileWriter csvWriter = new FileWriter("src/" + dbPath);
            
            for (int i = 0; i < names.length; i ++) {
                csvWriter.append(names[i] + ",");
                csvWriter.append(imagePaths[i] + ",");
                csvWriter.append(ingredientLists[i] + ",");
                csvWriter.append(directionLists[i] + "\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("No database found!");
        }

        readDb();
        drawRecipes(pnlCookbookResults, 1);
        
        imagePath = "";
        lblImage.setIcon(null);
        
        pnlNewRecipeLayer.setVisible(false);
        txtName.setText("");
        if (!imagePath.isBlank()) {
            File oldImage = new File("src" + imagePath);
            oldImage.delete();
            lblImage.setIcon(null);
        }
        txtNewIngredients.setText("");
        txtNewDirections.setText("");
    }//GEN-LAST:event_lblDoneMouseClicked

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        // TODO add your handling code here:
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loading.png")));
        int returnVal = fchUpload.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                    if (!imagePath.equals("")) {
                        File oldImage = new File("src" + imagePath);
                        oldImage.delete();
                        lblImage.setIcon(null);
                    }
            
            
            File imageFile = fchUpload.getSelectedFile();
            try {
                BufferedImage uploadedImage = ImageIO.read(imageFile);

                BufferedImage resizedImage = new BufferedImage(270, 150, BufferedImage.TYPE_INT_RGB);
                java.awt.Graphics2D graphics2D = resizedImage.createGraphics();
                graphics2D.drawImage(uploadedImage, 0, 0, 270, 150, null);
                graphics2D.dispose();
                String imageName = String.valueOf(System.currentTimeMillis());
                ImageIO.write(resizedImage, "jpg", new File("src/images/" + imageName + ".jpg"));
                imagePath = "/images/" + imageName + ".jpg";
                System.out.println(imagePath);
                while (getClass().getResource(imagePath) == null) {}
                
                lblImage.setIcon(new javax.swing.ImageIcon(resizedImage));

            } catch (IOException e) {
                System.out.println("problem accessing file" + imageFile.getAbsolutePath());
            }
        } else {
            if (!imagePath.equals("")) {
                lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
            } else {
                lblImage.setIcon(null);
            }
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
        // TODO add your handling code here:
        // Variables
        int index = buttonIndex;
        
        readDb();
        
        txtName.setText(names[index]);
        if (!imagePaths[index].isBlank()) {
            lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePaths[index])));
        }
        imagePath = imagePaths[index];
        txtNewIngredients.setText(ingredientLists[index].replace( "\u222B", "\n"));
        txtNewDirections.setText(directionLists[index].replace("\u222B", "\n"));
        lblDone.setText("Update Recipe");
        
        pnlNewRecipeLayer.setVisible(true);
        
        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbookSelected.png")));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipe.png")));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));
        
        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        
        pnlCookbookLayer.setVisible(true);
        pnlRecipeLayer.setVisible(false);
        pnlSearchLayer.setVisible(false);
        
    }//GEN-LAST:event_mnuEditActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        // TODO add your handling code here:
        // Variables
        int index = buttonIndex;
        javax.swing.JPanel panel = buttonPanel;
        
        try {
            readDb();
            
            names = remove(names, index);
            if (!imagePaths[index].isBlank()) {
                File oldImage = new File("src" + imagePaths[index]);
                oldImage.delete();
            }
            imagePaths = remove(imagePaths, index);
            ingredientLists = remove(ingredientLists, index);
            directionLists = remove(directionLists, index);
            
            
            FileWriter csvWriter = new FileWriter("src/" + dbPath);
            
            for (int i = 0; i < names.length; i ++) {
                csvWriter.append(names[i] + ",");
                csvWriter.append(imagePaths[i] + ",");
                csvWriter.append(ingredientLists[i] + ",");
                csvWriter.append(directionLists[i] + "\n");
            }

            csvWriter.flush();
            csvWriter.close();
            
            readDb();
            drawRecipes(pnlSearchResults, 0);
            drawRecipes(pnlCookbookResults, 1);
            
            
            lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbookSelected.png")));
            lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipe.png")));
            lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));

            lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
            lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
            lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));

            pnlCookbookLayer.setVisible(true);
            pnlRecipeLayer.setVisible(false);
            pnlSearchLayer.setVisible(false);
            
            recipeIndex = 0;
            } catch (IOException e) {
                System.out.println("Database not found!");
            }
        
    }//GEN-LAST:event_mnuDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (names.length > 0) {
            int x = java.awt.MouseInfo.getPointerInfo().getLocation().x - pnlRecipe.getLocationOnScreen().x;
            int y = java.awt.MouseInfo.getPointerInfo().getLocation().y - pnlRecipe.getLocationOnScreen().y;

            pmnEdit.show(pnlRecipe, x, y);
            buttonIndex = recipeIndex;
            buttonPanel = pnlCookbookResults;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void pnlSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSidebarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlSidebarMouseClicked

    private void lblCookbookSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCookbookSidebarMouseClicked
        // TODO add your handling code here:

        readDb();
        drawRecipes(pnlCookbookResults, 1);

        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbookSelected.png")));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipe.png")));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));

        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));

        pnlCookbookLayer.setVisible(true);
        pnlRecipeLayer.setVisible(false);
        pnlSearchLayer.setVisible(false);
    }//GEN-LAST:event_lblCookbookSidebarMouseClicked

    private void lblRecipeSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecipeSidebarMouseClicked
        // TODO add your handling code here:
        //Variables
        String regex = "\u222B";

        int index = recipeIndex;

        readDb();

        if (names.length > 0) {
            lblRecipeName.setText(names[index]);
            lstIngredients.setListData(ingredientLists[index].split(regex));
            lstDirections.setListData(directionLists[index].split(regex));
        }

        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbook.png")));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipeSelected.png")));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png")));

        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));

        pnlCookbookLayer.setVisible(false);
        pnlRecipeLayer.setVisible(true);
        pnlSearchLayer.setVisible(false);
    }//GEN-LAST:event_lblRecipeSidebarMouseClicked

    private void lblSearchSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchSidebarMouseClicked
        // TODO add your handling code here:

        readDb();
        drawRecipes(pnlSearchResults, 0);

        txtSearch.setText("");

        lblCookbookSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cookbook.png")));
        lblRecipeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/recipe.png")));
        lblSearchSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/searchSelected.png")));

        lblCookbookSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblRecipeSidebar.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        lblSearchSidebar.setFont(new java.awt.Font("Gill Sans MT", 1, 18));

        pnlCookbookLayer.setVisible(false);
        pnlRecipeLayer.setVisible(false);
        pnlSearchLayer.setVisible(true);

    }//GEN-LAST:event_lblSearchSidebarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCookbookJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCookbookJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCookbookJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCookbookJW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCookbookJW().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JFileChooser fchUpload;
    private javax.swing.JLabel lblAddRecipe;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblCookbook;
    private javax.swing.JLabel lblCookbookSidebar;
    private javax.swing.JLabel lblDirections;
    private javax.swing.JLabel lblDirectionsInst;
    private javax.swing.JLabel lblDone;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblIngredients;
    private javax.swing.JLabel lblIngredientsInst;
    private javax.swing.JLabel lblNewDirections;
    private javax.swing.JLabel lblNewIngredients;
    private javax.swing.JLabel lblRecipeName;
    private javax.swing.JLabel lblRecipeSidebar;
    private javax.swing.JLabel lblRecipeTitle;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblSearchSidebar;
    private javax.swing.JLabel lblWatsonCookbooks;
    private javax.swing.JLayeredPane lpnMain;
    private javax.swing.JList<String> lstDirections;
    private javax.swing.JList<String> lstIngredients;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JPopupMenu pmnEdit;
    private javax.swing.JPanel pnlAddRecipe;
    private javax.swing.JPanel pnlCookbookHeader;
    private javax.swing.JLayeredPane pnlCookbookLayer;
    private javax.swing.JPanel pnlCookbookResults;
    private javax.swing.JPanel pnlDirections;
    private javax.swing.JPanel pnlIngredients;
    private javax.swing.JPanel pnlIngredientsBox;
    private javax.swing.JPanel pnlNewDirections;
    private javax.swing.JPanel pnlNewIngredients;
    private javax.swing.JPanel pnlNewIngredientsBox;
    private javax.swing.JPanel pnlNewRecipe;
    private javax.swing.JPanel pnlNewRecipeLayer;
    private javax.swing.JPanel pnlRecipe;
    private javax.swing.JPanel pnlRecipeHeader;
    private javax.swing.JPanel pnlRecipeLayer;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSearchBox;
    private javax.swing.JPanel pnlSearchHeader;
    private javax.swing.JPanel pnlSearchLayer;
    private javax.swing.JPanel pnlSearchResults;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scpCookbookResults;
    private javax.swing.JScrollPane scpDirections;
    private javax.swing.JScrollPane scpIngredients;
    private javax.swing.JScrollPane scpNewDirections;
    private javax.swing.JScrollPane scpNewIngredients;
    private javax.swing.JScrollPane scpSearchResults;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNewDirections;
    private javax.swing.JTextArea txtNewIngredients;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

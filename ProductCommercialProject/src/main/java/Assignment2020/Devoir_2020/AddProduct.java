package Assignment2020.Devoir_2020;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.*;


public class AddProduct implements ActionListener {
	public void lunchFrame() {
		Frame f = new Frame("Add Product");
        f.setSize(600, 400); 
        f.setMinimumSize(new Dimension(400, 300));
        f.setBackground(Color.LIGHT_GRAY);

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        f.setLayout(gb);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1; 
        gbc.weighty = 1; 

        // Label Title
        Label title = new Label("Nouveau Produit");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST; 
        f.add(title, gbc);
        
        // TextField Nom
        TextField nom = new TextField();
        Label nameLabel = new Label("Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.2; 
        f.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1; 
        f.add(nom, gbc);

        // TextField "Prix" 
        TextField price = new TextField();
        Label priceLabel = new Label("Price:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.2;
        f.add(priceLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        f.add(price, gbc);

        // TextArea Description
        TextArea description = new TextArea();
        Label descLabel = new Label("Description:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.2;
        f.add(descLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 2; 
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1;
        gbc.weighty = 1; 
        f.add(description, gbc);
        gbc.gridheight = 1; 

        // Choice for Commercial ID
        Choice commercialId = new Choice();
        setCommercialsToCombox(commercialId);
        // Positionning and dimentions of comboBox
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.2;
        f.add(commercialId, gbc);
        Label commLabel = new Label("(Commercial)");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST; 
        f.add(commLabel, gbc);

        // Button Add
        Button addBtn = new Button("Add");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.weightx = 0; 
        gbc.weighty = 0; 
        f.add(addBtn, gbc);
 
        // Show frame
        f.setVisible(true);
        
        // Handling Button Event Listener 
        addBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) throws NumberFormatException {
        		try {
        			// Handling "Adding Product" into DB
        			double newPrdPrice = Double.parseDouble(price.getText());
        			CommercialDaoImpl sqlComm = new CommercialDaoImpl();
        			Commercial commercialprd = sqlComm.getCommercialById(commercialId.getSelectedItem());
        			Product newProduct = new Product(nom.getText(),description.getText(),newPrdPrice,commercialprd);
            		ProductDaoImpl sqlPrdt = new ProductDaoImpl();
            		sqlPrdt.add(newProduct);
            		
            		// After the button click erase data added by user
            		nom.setText("");
            		price.setText("");
            		description.setText("");

        		} catch(NumberFormatException err) {	
        			DisplayDialogMssg("Please enter a valid Price", f);
        			err.printStackTrace();
        		}
        		
        	}
        });
        
        
        // Handling the close button in the window
	      f.addWindowListener(new WindowAdapter() {
	    		public void windowClosing(WindowEvent we) {
	    		f.dispose();
	    		}
	    		}
	      );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
   
	public void setCommercialsToCombox(Choice commercialId) {
		Set<Commercial> commrcls = new HashSet<Commercial>();
        CommercialDaoImpl commercialSql = new CommercialDaoImpl();
        commrcls = commercialSql.selectAll();
        for(Commercial commercial : commrcls) {
        	commercialId.add(commercial.getMatricule());
        }
        
	}
	
	public void DisplayDialogMssg(String labeledMssg , Frame f) {
		 Dialog Errormsg = new Dialog(f,"Error Message",false);
	        Errormsg.setMinimumSize(new Dimension(200,200));
	        Errormsg.setLayout(new FlowLayout());
	        Button okBtn = new Button("OK");
	        okBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Errormsg.setVisible(false);
	        	}
	        });
	        Errormsg.add(okBtn);
	        Errormsg.add(new Label(labeledMssg));
	        Errormsg.setVisible(true);
	        Errormsg.addWindowListener(new WindowAdapter() {
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        		Errormsg.dispose();
	        	}
	        });
			
	}
	
}


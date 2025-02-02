package interfata;


import clase.Asigurare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SelectiaMasinilor extends JFrame {

    private JLabel makerLabel;
    private JLabel modelLabel;
    private JLabel engineTypeLabel;
    private JLabel fuelTypeLabel;
    private JLabel fabricationYearLabel;
    private JLabel pollutionNormLabel;
    private JLabel nameLabel;


    private JComboBox<String> makerComboBox;
    private JComboBox<String> modelComboBox;
    private JComboBox<String> engineTypeComboBox;
    private JComboBox<String> fuelTypeComboBox;
    private JComboBox<String> fabricationYearComboBox;
    private JComboBox<String> pollutionNormComboBox;
    private JTextField nameField;



    private void writeSelectedInformationToFile(String nameField, String selectedMaker, String selectedModel, String selectedEngineType, String selectedFuelType, String selectedFabricationYear, String selectedPollutionNorm) {
        File file = new File("carsDatabase.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(nameField + "," + selectedMaker + "," + selectedModel + "," + selectedEngineType + "," + selectedFuelType + "," + selectedFabricationYear + "," + selectedPollutionNorm + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public SelectiaMasinilor() {
        setTitle("E-Asigurari - Selecteaza Masina");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        makerLabel = new JLabel("Fabricant");
        modelLabel = new JLabel("Model");
        engineTypeLabel = new JLabel("Motorizare");
        fuelTypeLabel = new JLabel("Combustibil");
        fabricationYearLabel = new JLabel("Anul fabricatiei");
        pollutionNormLabel = new JLabel("Norma de poluare");
        nameLabel = new JLabel("Nume:");

        makerComboBox = new JComboBox<>(new String[]{"Audi", "BMW", "Chevrolet", "Citroen", "Dacia", "Fiat", "Ford", "Honda", "Hyundai", "Jaguar", "Jeep", "Kia", "Land Rover", "Mazda", "Mercedes - Benza", "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Skoda", "Tesla", "Toyota", "Volkswagen"});
        modelComboBox = new JComboBox<>(new String[]{});
        engineTypeComboBox = new JComboBox<>(new String[]{""});
        fuelTypeComboBox = new JComboBox<>(new String[]{"Benzina", "Electric", "Hibrid", "Motorina"});
        fabricationYearComboBox = new JComboBox<>(new String[]{"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2015", "2017", "2018", "2019", "2020", "2021", "2022", "2023"});
        pollutionNormComboBox = new JComboBox<>(new String[]{"Euro 4", "Euro 5", "Euro 6", "Non Euro"});
        nameField = new JTextField(40);


        final JButton submitButton = new JButton("Confirma");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedMaker = makerComboBox.getSelectedItem().toString();
                String selectedModel = modelComboBox.getSelectedItem().toString();
                String selectedEngineType = engineTypeComboBox.getSelectedItem().toString();
                String selectedFuelType = fuelTypeComboBox.getSelectedItem().toString();
                String selectedFabricationYear = fabricationYearComboBox.getSelectedItem().toString();
                String selectedPollutionNorm = pollutionNormComboBox.getSelectedItem().toString();
                String name = nameField.getText();
                writeSelectedInformationToFile(name, selectedMaker, selectedModel, selectedEngineType, selectedFuelType, selectedFabricationYear, selectedPollutionNorm);
                SubmitButtonHandler(e);
            }
            private void SubmitButtonHandler(ActionEvent event) {


                Asigurare insurance = new Asigurare();
                try {
                    insurance.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



        add(makerLabel);
                add(makerComboBox);
                add(modelLabel);
                add(modelComboBox);
                add(engineTypeLabel);
                add(engineTypeComboBox);
                add(fuelTypeLabel);
                add(fuelTypeComboBox);
                add(fabricationYearLabel);
                add(fabricationYearComboBox);
                add(pollutionNormLabel);
                add(pollutionNormComboBox);
                add(nameLabel);
                add(nameField);
                add(submitButton);


                makerComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedMaker = (String) makerComboBox.getSelectedItem();
                        if (selectedMaker.equals("Audi")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"A1", "A3", "A4", "A4 Allroad", "A5", "A6", "A6 Allroad", "A7", "A8", "e-tron", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"2.0TDI", "1.6TDI", "3.0TDI", "3.0TFSI", "1.4TFSI", "2.0TFSI"}));
                        } else if (selectedMaker.equals("BMW")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"i3", "M1", "M2", "M3", "M4", "M5", "M8", "Sera 1", "Seria 3", "Seria 4", "Seria 5", "Seria 7", "X1", "X2", "X3", "X4", "X5", "X6"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"M54", "M56", "N52", "N54", "N55", "N63", "N74", "S50", "S52", "S54", "S55", "S63", "S65"}));
                        } else if (selectedMaker.equals("Chevrolet")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Aveo", "Camaro", "Spark"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Small Block V8", "Big Block V8", "LS V8", "LS3 V8", "LS7 V8", "LT1 V8", "LT4 V8", "Ecotech 4-Cylinder", "Duramax Diesel 6.6L V8"}));
                        } else if (selectedMaker.equals("Citroen")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Berlingo", "C-Elysee", "C1", "C2", "C3", "C4", "C5", "DS3", "DS4", "DS5"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"TU", "XU", "DW", "EH", "EW", "BX", "CX", "XDP", "XANTIA", "XSARA", "C5", "C3", "C4", "DS3", "DS5"}));
                        } else if (selectedMaker.equals("Dacia")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Dokker", "Duster", "Jogger", "Lodgy", "Logan", "Sandero", "Sandero Stepway", "Spring"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"ECO-G 100", "Blue dCi 115", "TCe 130", ""}));
                        } else if (selectedMaker.equals("Fiat")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"500", "Doblo", "Ducato", "Grande Punto", "Panda", "Punto", "Tipo"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"0.9 TWINAIR", "0.9 TWINAIR TURBO", "1.2", "1.2 Start & Stop", "1.3", "1.6"}));
                        } else if (selectedMaker.equals("Ford")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"C-MAX", "EcoSport", "Edge", "Explorer", "Fiesta", "Focus", "Kuga", "Mondeo", "Mustang", "Puma", "Ranger", ""}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"4.6L V8 Modular", "5.0L Coyote V8", "5.4L Triton V8", "3.7L Cyclone V6", "2.7L EcoBoost V6", "3.5L EcoBoost V6", "5.0L Modular V8"}));
                        } else if (selectedMaker.equals("Honda")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Accord", "Civic", "CR-V", "HR-V"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"B16A", "B18C", "D15B", "D16A", "F20C", "F22C", "H22A", "K20A", "K24A"}));
                        } else if (selectedMaker.equals("Hyundai")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Coupe", "Elantra", "i10", "i20", "i30", "IONIQ", "ix35", "KONA", "Santa Fe", "Tucson"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Gamma", "Nu", "Theta", "Theta II", "GDI", "T-GDI", "Lambda", "Delta", "Beta"}));
                        } else if (selectedMaker.equals("Jaguar")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"E-Pace", "F-Pace", "S-Type", "XE", "XF", "XJ"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"AJ-V6", "V8 AJ-V8", "V12 AJ-V12", "V8 AJ133", "V8 AJ126", "V6 AJ-V6 Gen III"}));
                        } else if (selectedMaker.equals("Jeep")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Cherokee", "Compass", "Gladiator", "Grand Cherokee", "Renegade", "Wrangler"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"2.0L Turbo I4", "2.4L I4", "3.6L V6", "3.7L V6", "4.0L I6", "5.7L V8"}));
                        } else if (selectedMaker.equals("Kia")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Ceed", "Niro", "Picanto", "Rio", "Sorento", "Sportage"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"GDI", "MPI", "CRDi", "T-GDI", "HEV", "PHEV"}));
                        } else if (selectedMaker.equals("Land Rover")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Defender", "Discovery", "Freelander", "Range Rover", "Range Rover Evoque"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"2.0L Ingenium 4-Cylinder Petrol", "2.0L Si4 4-Cylinder Turbocharged Petrol", "3.0L Si6 6-Cylinder Turbocharged Petrol", "3.0L TD6 V6 Diesel", "2.2L Td4 4-Cylinder Diesel", "2.0L eD4 4-Cylinder Diesel", "3.0L SDV6 V6 Diesel", "5.0L V8 Supercharged Petrol"}));
                        } else if (selectedMaker.equals("Mazda")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"2", "3", "5", "6", "CX-3", "CX-30", "CX-5", "CX-60", "CX-7"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"SkyActiv-G", "SkyActiv-D", "MZR", "KF-VE", "LF-VE", "RF-Turbo"}));
                        } else if (selectedMaker.equals("Mercedes - Benz")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"A", "AMG", "B", "C", "CLA", "CLC", "CLK", "CLS", "E", "GLA", "GLC", "GLE", "GLK", "ML", "S", ""}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"M274", "M276", "M278", "M113", "M119", "M120", "M272", "M273", "M271", "M158", "M176", "M177"}));
                        } else if (selectedMaker.equals("Nissan")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Juke", "LEAF", "Micra", "Navara", "Pathfinder", "Patrol", "Primera", "Qashqai", "X-Trail"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"KA24DE", "SR20DET", "RB20DET", "RB25DET", "RB26DETT", "VQ35DE", "VQ37VHR", "VR38DETT"}));
                        } else if (selectedMaker.equals("Opel")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Antara", "Astra", "Corsa", "Crossland", "Grandland X", "Insignia", "Meriva", "Mokka", "Vectra", "Zafira"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"KA24DE", "SR20DET", "RB20DET", "RB25DET", "RB26DETT", "VQ35DE", "VQ37VHR", "VR38DETT"}));
                        } else if (selectedMaker.equals("Peugeot")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"107", "2008", "206", "208", "3008", "301", "307", "308", "5008", "508"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"1.6 THP", "1.4 VTi", "1.2 PureTech", "1.6 BlueHDi", "2.0 BlueHDi", "1.5 BlueHDi", "1.2 PureTech 130", "1.6 e-HDi", "2.0 HDi", "1.0 PureTech", "1.6 e-THP"}));
                        } else if (selectedMaker.equals("Renault")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Arkana", "Captur", "Clio", "Espace", "Fluence", "Grand Scenic", "Kadjar", "Kangoo", "Koleos", "Megane", "Zoe"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"DCI", "TCe", "F4R", "K4J", "M5M", "F9Q", "H5Ft", "H4Bt"}));
                        } else if (selectedMaker.equals("Seat")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Altea", "Arona", "Ateca", "Exeo", "Ibiza", "Leon", "Toledo"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"I", "V", "H", "Boxer", "Flat", "Inline", "Rotary", "Straight"}));
                        } else if (selectedMaker.equals("Skoda")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Citigo", "Fabia", "Kamiq", "Karoq", "Kodiaq", "Octavia", "Rapid", "Superb"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"1.0 TSI", "1.4 TSI", "1.4 TSI", "1.8 TSI", "1.4 TDI"}));
                        } else if (selectedMaker.equals("Tesla")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Model 3", "Model S", "Model X", "Model Y"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Electric"}));
                        } else if (selectedMaker.equals("Toyota")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Auris", "Avensis", "Aygo", "C-HR", "Camry", "Celica", "Corolla", "Hilux", "Land Cruiser", "Prius", "RAV4", "Supra", "Yaris"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"DCI", "TCe", "F4R", "K4J", "M5M", "F9Q", "H5Ft", "H4Bt"}));
                        } else if (selectedMaker.equals("Volkswagen")) {
                            modelComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Amarok", "Arteon", "Golf", "Golf Plus", "Jetta", "Passat", "Passat CC", "Phaeton", "Polo", "Scirocco", "Sharan", "T-Cross", "T-ROC", "Taigo", "Touareg"}));
                            engineTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"1.8T", "2.0T", "2.0L TDI", "1.9L TDI", "2.5L", "2.0L Turbo", "1.6L", "1.4L TSI", "2.8L VR6", "1.2L TSI"}));

                        }
                    }
                });


            }

            public static void main(String[] args) {
                SelectiaMasinilor carSelectionUI = new SelectiaMasinilor();
                carSelectionUI.setVisible(true);
            }

        };



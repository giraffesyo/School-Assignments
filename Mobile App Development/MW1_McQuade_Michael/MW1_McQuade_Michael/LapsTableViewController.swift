//
//  LapsTableViewController.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/29/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit

class LapsTableViewController: UITableViewController {
    
    var stopwatch: Stopwatch = Stopwatch()
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        if let navcontroller = self.navigationController {
            let height = navcontroller.toolbar.frame.height
            let width = navcontroller.toolbar.frame.width
            let averageLabel = UILabel(frame: CGRect(x: 0, y: 0, width: width, height: height))
            averageLabel.text = "Average: \(stopwatch.getFormattedAverageTime())"
            
            averageLabel.textAlignment = NSTextAlignment.center
            let toolbarLabel = UIBarButtonItem(customView: averageLabel)
            self.toolbarItems = [toolbarLabel]
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
       
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false
        
        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    // MARK: - Table view data source
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stopwatch.getLapCount()
    }
    
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "lap time cell", for: indexPath)
        
        // Configure the cell...
        cell.textLabel?.text = "Lap \(indexPath[1]+1): \(stopwatch.getFormattedTimeForLap(lap: indexPath[1]))"
        return cell
    }
    
    
    /*
     // Override to support conditional editing of the table view.
     override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the specified item to be editable.
     return true
     }
     */
    
    /*
     // Override to support editing the table view.
     override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
     if editingStyle == .delete {
     // Delete the row from the data source
     tableView.deleteRows(at: [indexPath], with: .fade)
     } else if editingStyle == .insert {
     // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
     }
     }
     */
    
    /*
     // Override to support rearranging the table view.
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
     
     }
     */
    
    /*
     // Override to support conditional rearranging of the table view.
     override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the item to be re-orderable.
     return true
     }
     */
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destination.
     // Pass the selected object to the new view controller.
     }
     */
    
}

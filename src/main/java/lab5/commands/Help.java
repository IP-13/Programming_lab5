package lab5.commands;

/**
 * Help class represents concrete command that shows help for available commands
 */
public class Help extends AbstractCommand {
    /**
     * Constructor
     */
    public Help() {

    }

    /**
     * Shows help for available commands
     */
    @Override
    public void execute() {
        System.out.println(
                                """
                                help : show help for available commands
                                info : print information about the collection to standard output (type, initialization date, number of elements, etc.)
                                show : print to standard output all elements of the collection in string representation
                                add {element} : add a new element to the collection
                                update id {element} : update the value of the collection element whose id is equal to the given one
                                remove_by_id id : remove an element from the collection by its id
                                clear : clear the collection
                                save : save the collection to a file
                                execute_script file_name : read and execute script from specified file. The script contains commands in the same form in which they are entered by the user in interactive mode.
                                exit : exit the program (without saving to a file)
                                remove_head : output the first element of the collection and remove it
                                add_if_max {element} : add a new element to the collection if its value is greater than the value of the largest element in this collection
                                history : print the last 11 commands (without their arguments)
                                average_of_discount : display the average value of the discount field for all items in the collection
                                filter_by_refundable refundable : display items whose refundable field value is equal to the given one
                                print_descending : print the elements of a collection in descending order
                                """
        );
    }

    @Override
    public void undo() {

    }
}

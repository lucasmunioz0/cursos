using System;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    public class Program
    {
        static void Main(string[] args)
        {
            

            var workFlow = new WorkFlow();
            workFlow.Add(new VideoUploader());
            workFlow.Add(new CallWebServices());
            workFlow.Add(new SendEmail());
            workFlow.Add(new ChangeStatus());

            var workFlowEngine = new WorkFlowEngine();
            workFlowEngine.Run(workFlow);

            Console.ReadLine();
        }
    }

    public class WorkFlowEngine
    {
        public void Run(IWorkFlow workFlow)
        {
            foreach (var activity in workFlow.GetActivities())
            {
                activity.Execute();
            }
        }
    }
}

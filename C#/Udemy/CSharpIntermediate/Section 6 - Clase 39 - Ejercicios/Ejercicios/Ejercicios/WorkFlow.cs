using System;
using System.Collections.Generic;
using System.Linq;

namespace Ejercicios
{
    public class WorkFlow : IWorkFlow
    {
        private readonly List<IActivity> _activities;

        public WorkFlow()
        {
            _activities = new List<IActivity>();
        }

        public void ClearActivities()
        {
            _activities.Clear();
        }

        public IEnumerable<IActivity> GetActivities()
        {
            return _activities;
        }

        public void Add(IActivity activity)
        {
            if (activity == null)
                throw new ArgumentNullException($"The activity can't be null.");
            _activities.Add(activity);
        }

        public void Remove(IActivity activity)
        {
            _activities.Remove(activity);
        }
    }
}